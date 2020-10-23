package cn.lh.travel.controller;

import cn.lh.travel.entity.Product;
import cn.lh.travel.exception.ExceptionEnum;
import cn.lh.travel.exception.MyException;
import cn.lh.travel.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        List<Product> products = productService.findAll();
        map.put("products", products);

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

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam("id")String id){
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(id);

        mv.addObject("product", product);
        mv.setViewName("product-show");

        return mv;
    }

    @RequestMapping("/toProductEdit")
    public ModelAndView toProductEdit(@RequestParam("id")String id){
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(id);

        mv.addObject("product", product);
        mv.setViewName("product-edit");

        return mv;
    }

    @RequestMapping("/updateProduct")
    public ModelAndView updateProduct(Product product){
        ModelAndView mv = new ModelAndView();



        mv.addObject("product", product);
        mv.setViewName("product-edit");

        return mv;
    }


}
