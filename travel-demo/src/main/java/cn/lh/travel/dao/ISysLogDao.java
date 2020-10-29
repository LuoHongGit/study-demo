package cn.lh.travel.dao;

import cn.lh.travel.entity.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ISysLogDao {

    @Insert("insert into lh_sysLog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog) throws Exception;

    @Select("select * from lh_sysLog order by visitTime desc")
    List<SysLog> findAll() throws Exception;
}
