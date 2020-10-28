package cn.lh.travel.dao;

import cn.lh.travel.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface IMemberDao {

    @Select("select * from lh_member where id=#{id}")
    public Member findById(String id) throws Exception;



}
