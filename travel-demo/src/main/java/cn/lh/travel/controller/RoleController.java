package cn.lh.travel.controller;

import cn.lh.travel.entity.Permission;
import cn.lh.travel.entity.Role;
import cn.lh.travel.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/deleteRole")
    public String deleteRole(@RequestParam(name="id",required = true) int roleId) throws Exception {
        roleService.deleteRoleById(roleId);
        return "redirect:findAll";
    }

    //角色详情查询
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) int roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);

        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }

    //给角色添加权限
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) int roleId, @RequestParam(name = "ids", required = true) int[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll";
    }

    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) int roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据roleId查询role
        Role role = roleService.findById(roleId);
        //根据roleId查询可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;

    }

    @RequestMapping("/save")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findByPage";
    }

    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                   @RequestParam(name = "size", required = true, defaultValue = "5") Integer size
    ) throws Exception {
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo  = roleService.findByPage(page, size);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("role-page-list");
        return mv;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList", roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/toRoleAddPage")
    public ModelAndView toRoleAddPage() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-add");
        return mv;
    }
}
