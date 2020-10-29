package cn.lh.travel.service;


import cn.lh.travel.entity.SysLog;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ISysLogService {

    public void save(SysLog sysLog) throws Exception;

    PageInfo findByPage(int page, int size) throws Exception;

    List<SysLog> findAll() throws Exception;
}
