package cn.lh.travel.dao;

import cn.lh.travel.entity.Traveller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ITravellerDao {
    @Select("select * from traveller")
    List<Traveller> findAll();

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
