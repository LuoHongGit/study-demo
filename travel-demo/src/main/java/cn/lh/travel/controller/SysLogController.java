package cn.lh.travel.controller;

import cn.lh.travel.entity.SysLog;
import cn.lh.travel.service.ISysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll();
        mv.addObject("sysLogs", sysLogList);
        mv.setViewName("syslog-list");
        return mv;
    }

    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(value = "page",required = true,defaultValue = "1")Integer page,
                                   @RequestParam(value = "size",required = true,defaultValue = "10")Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = sysLogService.findByPage(page, size);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("syslog-page-list");
        return mv;
    }
}
