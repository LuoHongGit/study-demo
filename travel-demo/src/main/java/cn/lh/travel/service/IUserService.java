package cn.lh.travel.service;

import cn.lh.travel.entity.Role;
import cn.lh.travel.entity.UserInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    PageInfo findByPage(int page, int size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    void update(UserInfo userInfo) throws Exception;

    UserInfo findById(int id) throws Exception;

    List<Role> findOtherRoles(int userId) throws Exception;

    void addRoleToUser(int userId, int[] roleIds);
}
