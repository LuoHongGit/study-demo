package cn.lh.travel.service.impl;

import cn.lh.travel.dao.ITravellerMapper;
import cn.lh.travel.entity.Traveller;
import cn.lh.travel.service.TravellerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TravellerServiceImpl implements TravellerService {

    @Resource
    private ITravellerMapper travellerMapper;



    @Override
    public List<Traveller> findAll() {
        return travellerMapper.findAll();
    }
}
