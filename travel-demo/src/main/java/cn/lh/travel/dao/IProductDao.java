package cn.lh.travel.dao;

import cn.lh.travel.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface IProductDao {

    //根据id查询产品
    @Select("select * from lh_product where id=#{id}")
    public Product findById(Integer id);

    //查询所有的产品信息
    @Select("select * from lh_product")
    public List<Product> findAll();

    //查询所有的产品信息带模糊查询
    @Select("<script>select * from lh_product <where><if test='key != null or key != 0'> and productNum like %${key}% or productName like %${key}% or cityName like %${key}% </if></where></script>")
    public List<Product> findAllByKey(@Param("key") String key);

    //插入产品
    @Insert("insert into lh_product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(Product product);

    //更新产品
    @Update("update lh_product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    void update(Product product);

    //删除商品
    @Delete("delete from lh_product where id = #{id}")
    void delete(Integer id);
}
