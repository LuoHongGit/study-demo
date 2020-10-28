package cn.lh.travel.dao;

import cn.lh.travel.entity.Permission;
import cn.lh.travel.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IRoleDao {

    //根据用户id查询出所有对应的角色
    @Select("select * from lh_role where id in (select roleId from lh_users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "cn.lh.travel.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(int userId) throws Exception;

    @Select("select * from lh_role")
    List<Role> findAll() throws Exception;

    @Insert("insert into lh_role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Update("update lh_role set roleName=#{roleName},roleDesc=#{roleDesc} where id=#{id}")
    void update(Role role);

    @Select("select * from lh_role where id=#{roleId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "cn.lh.travel.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(int roleId);

    @Select("select * from lh_permission where id not in (select permissionId from lh_role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(int roleId);

    @Insert("insert into lh_role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") int roleId, @Param("permissionId") int permissionId);

    @Delete("delete from lh_users_role where roleId=#{roleId}")
    void deleteFromUser_RoleByRoleId(int roleId);
    @Delete("delete from lh_role_permission where roleId=#{roleId}")
    void deleteFromRole_PermissionByRoleId(int roleId);

    @Delete("delete from lh_role where id=#{roleId}")
    void deleteRoleById(int roleId);
}
