package cn.lh.travel.service.impl;

import cn.lh.travel.dao.IRoleDao;
import cn.lh.travel.entity.Permission;
import cn.lh.travel.entity.Role;
import cn.lh.travel.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public void deleteRoleById(int roleId) {
        //从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表中删除
        roleDao.deleteRoleById(roleId);
    }

    @Override
    public void addPermissionToRole(int roleId, int[] permissionIds) {
        for(int permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public Role findById(int roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(int roleId) {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public void update(Role role) throws Exception {
        roleDao.update(role);
    }

    @Override
    public List<Role> findAll() throws Exception{
        return roleDao.findAll();
    }

    @Override
    public PageInfo findByPage(int page, int size) throws Exception {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return new PageInfo(roleDao.findAll());
    }
}
