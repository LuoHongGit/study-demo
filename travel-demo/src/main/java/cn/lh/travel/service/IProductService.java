package cn.lh.travel.service;

import cn.lh.travel.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    List<Product> findAllByPageAndKey(Integer page, Integer size,String key);

    List<Product> findByPage(Integer page, Integer size);

    void save(Product product);

    Product findById(Integer id);

    void update(Product product);

    void delete(Integer id);
}
