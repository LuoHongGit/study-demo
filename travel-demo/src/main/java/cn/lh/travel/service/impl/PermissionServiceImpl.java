package cn.lh.travel.service.impl;

import cn.lh.travel.dao.IPermissionDao;
import cn.lh.travel.entity.Permission;
import cn.lh.travel.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Resource
    private IPermissionDao permissionDao;

    @Override
    public void deleteById(int id) throws Exception {
        permissionDao.deleteFromRole_Permission(id);
        permissionDao.deleteById(id);
    }

    @Override
    public Permission findById(int id) throws Exception {
        return permissionDao.findById(id);
    }

    @Override
    public void save(Permission permission) throws Exception{
        permissionDao.save(permission);
    }

    @Override
    public void update(Permission permission) throws Exception {
        permissionDao.update(permission);
    }

    @Override
    public List<Permission> findAll() throws Exception{
        return permissionDao.findAll();
    }

    @Override
    public PageInfo findByPage(int page,int size) throws Exception{
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return new PageInfo(permissionDao.findAll());
    }
}
