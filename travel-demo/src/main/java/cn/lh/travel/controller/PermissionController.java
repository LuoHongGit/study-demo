package cn.lh.travel.controller;

import cn.lh.travel.entity.Permission;
import cn.lh.travel.service.IPermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;
    @RequestMapping("/deletePermission")
    public String deletePermission(Integer id) throws Exception {
        permissionService.deleteById(id);
        return "redirect:findByPage";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(Integer id) throws Exception {
      Permission permission=  permissionService.findById(id);
      ModelAndView mv=new ModelAndView();
      mv.setViewName("permission-show");
      mv.addObject("permission",permission);
      return mv;
    }

    @RequestMapping("/save")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findByPage";
    }

    @RequestMapping("/update")
    public String update(Permission permission) throws Exception {
        permissionService.update(permission);
        return "redirect:findByPage";
    }

    @RequestMapping("/toPermissionEditPage")
    public ModelAndView toPermissionEditPage(Integer id) throws Exception {
        Permission permission=  permissionService.findById(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("permission-edit");
        mv.addObject("permission",permission);
        return mv;
    }

    @RequestMapping("/toPermissionAddPage")
    public ModelAndView toPermissionAddPage() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("permission-add");
        return mv;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                   @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        PageInfo pageInfo = permissionService.findByPage(page, size);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("permission-page-list");
        return mv;
    }
}
