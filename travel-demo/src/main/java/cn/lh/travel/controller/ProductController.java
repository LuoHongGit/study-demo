package cn.lh.travel.controller;

import cn.lh.travel.entity.Orders;
import cn.lh.travel.entity.Product;
import cn.lh.travel.exception.ExceptionEnum;
import cn.lh.travel.exception.MyException;
import cn.lh.travel.service.IProductService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String toProductList(Map map, String key) throws MyException {
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
        return "redirect:findByPage";
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

    @PostMapping("/update")
    public String updateProduct(Product product){
        productService.update(product);

        return "redirect:findByPage";
    }

    @GetMapping("/delete")
    public String delete(int id){
        productService.delete(id);

        return "redirect:findByPage";
    }

    @RequestMapping("/findByPage")
    public ModelAndView findAllByPage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                      @RequestParam(name = "size", required = true, defaultValue = "5") Integer size,
                                      @RequestParam(name = "key", required = false) String key
                                      ) {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAllByPageAndKey(page, size, key);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(productList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("key", key);

        mv.setViewName("product-page-list");
        return mv;
    }

}
