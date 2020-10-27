package cn.lh.travel.service;


import cn.lh.travel.entity.Permission;
import cn.lh.travel.entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IRoleService {

    List<Role> findAll() throws Exception;

    PageInfo findByPage(int page, int size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(int roleId) throws  Exception;

    List<Permission> findOtherPermissions(int roleId) throws Exception;

    void addPermissionToRole(int roleId, int[] permissionIds) throws Exception;

    void deleteRoleById(int roleId) throws Exception;
}
