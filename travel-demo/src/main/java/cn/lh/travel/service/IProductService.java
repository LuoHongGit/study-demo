package cn.lh.travel.service;

import cn.lh.travel.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(String id);

    void update(Product product);

    void delete(int id);
}
