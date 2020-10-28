package cn.lh.travel.service;


import cn.lh.travel.entity.Permission;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IPermissionService {

    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    void update(Permission permission) throws Exception;

    Permission findById(int id) throws Exception;

    void deleteById(int id) throws Exception;

    PageInfo findByPage(int page, int size) throws Exception;
}
