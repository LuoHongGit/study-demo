package cn.lh.travel.controller;

import cn.lh.travel.entity.Product;
import cn.lh.travel.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping("/toProductList")
    public String toProductList() {
        //List<Product> products = productService.findAll();

        return "productList";
    }
}
