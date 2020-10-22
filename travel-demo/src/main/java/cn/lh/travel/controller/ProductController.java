package cn.lh.travel.controller;

import cn.lh.travel.entity.Product;
import cn.lh.travel.exception.ExceptionEnum;
import cn.lh.travel.exception.MyException;
import cn.lh.travel.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 商品控制层
 */
@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * 查询产品列表
     * @param map
     * @return
     * @throws MyException
     */
    @RequestMapping("/toProductList")
    public String toProductList(Map map) throws MyException {
        try {
            List<Product> products = productService.findAll();
            map.put("products", products);
        } catch (Exception e) {
            log.error("toProductList...查询产品列表失败");
            e.printStackTrace();
            throw new MyException("查询产品列表失败", 444);
        }

        return "product-list";
    }

    /**
     * 产品添加
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:toProductList";
    }

    @RequestMapping("toAddProduct")
    public String toAddProductPage(){
        return "product-add";
    }


}
