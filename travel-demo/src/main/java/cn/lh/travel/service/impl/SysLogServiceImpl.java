package cn.lh.travel.service.impl;

import cn.lh.travel.dao.ISysLogDao;
import cn.lh.travel.entity.SysLog;
import cn.lh.travel.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Override
    public PageInfo findByPage(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return new PageInfo(sysLogDao.findAll());
    }

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }
}
