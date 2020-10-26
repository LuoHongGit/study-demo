package cn.lh.travel.service;


import cn.lh.travel.entity.Permission;

import java.util.List;

public interface IPermissionService {

    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(int id) throws Exception;

    void deleteById(int id) throws Exception;
}
