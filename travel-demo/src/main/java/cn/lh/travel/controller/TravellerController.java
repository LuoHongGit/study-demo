package cn.lh.travel.controller;

import cn.lh.travel.entity.Traveller;
import cn.lh.travel.service.TravellerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/traveller")
public class TravellerController {
    @Resource
    private TravellerService travellerService;

    @RequestMapping("/findAll")
    public String findAll(Map map){
        List<Traveller> travellerList = travellerService.findAll();

        map.put("travellers", travellerList);

        return "traveller";
    }
}
