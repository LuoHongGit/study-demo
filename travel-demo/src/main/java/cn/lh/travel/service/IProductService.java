package cn.lh.travel.service;

import cn.lh.travel.entity.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
