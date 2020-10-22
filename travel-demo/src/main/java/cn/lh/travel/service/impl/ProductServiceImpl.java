package cn.lh.travel.service.impl;

import cn.lh.travel.dao.IProductDao;
import cn.lh.travel.entity.Product;
import cn.lh.travel.service.IProductService;
import cn.lh.travel.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public void save(Product product) {
        product.setId(UUIDUtils.getUUID());
        productDao.save(product);
    }

    @Override
    public List<Product> findAll() throws Exception{
        return productDao.findAll();
    }
}
