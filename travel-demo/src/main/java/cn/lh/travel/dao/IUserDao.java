package cn.lh.travel.dao;

import cn.lh.travel.entity.Role;
import cn.lh.travel.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUserDao {

    @Select("select * from lh_users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "cn.lh.travel.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username) throws Exception;

    @Select("select * from lh_users")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into lh_users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    @Update("update lh_users set email=#{email},username=#{username},password=#{password},phoneNum=#{phoneNum},status=#{status} where id = #{id}")
    void update(UserInfo userInfo) throws Exception;

    @Select("select * from lh_users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "cn.lh.travel.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(int id) throws Exception;

    @Select("select * from lh_role where id not in (select roleId from lh_users_role where userId=#{userId})")
    List<Role> findOtherRoles(int userId);

    @Insert("insert into lh_users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId);
}
