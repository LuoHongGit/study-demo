package cn.lh.travel.dao;

import cn.lh.travel.entity.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IPermissionDao {
    //查询与role关联的所有的权限
    @Select("select * from lh_permission where id in (select permissionId from lh_role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(int id) throws Exception;


    @Select("select * from lh_permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into lh_permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    @Update("update lh_permission set permissionName=#{permissionName},url=#{url} where id=#{id}")
    void update(Permission permission) throws Exception;

    @Select("select * from lh_permission where id=#{id}")
    Permission findById(int id) throws Exception;

    @Delete("delete from lh_role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(int id) throws Exception;

    @Delete("delete from lh_permission where id=#{id}")
    void deleteById(int id) throws Exception ;
}
