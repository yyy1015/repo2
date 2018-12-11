package cn.itcast.yyy.controller;


import cn.itcast.yyy.domain.Product;
import cn.itcast.yyy.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 分页查询所有的数据
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "4") Integer size){
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll(page,size);
        PageInfo pg = new PageInfo(products);
        mv.addObject("productList",pg);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 添加商品
     * @param product
     * @return
     */
    @RequestMapping("/saveProduct")
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:findAll";
    }

    /**
     * 根据id查询数据
     * @param ids
     * @return
     */
    @RequestMapping("/delById")
    public String delById(String[] ids){
        productService.delById(ids);
        return "redirect:findAll";
    }


    /**
     * 根据城市名字查询数据
     * @param cityName
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/findByName")
    public ModelAndView findByName(String cityName, HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("utf-8");
        List<Product> products = productService.findByName(cityName);
        System.out.println(cityName);
        ModelAndView mv = new ModelAndView();
        mv.addObject("products",products);
        mv.setViewName("product-list2");
        return mv;
    }


/*    @RequestMapping("/findAll")
    public ModelAndView findAll2(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll(page,size);
        PageInfo pg = new PageInfo(products);
        mv.addObject("productList",pg);
        mv.setViewName("product-list3");
        return mv;
    }*/

    @RequestMapping("/openSta")
    public String openSta(String[] ids){
        productService.openSta(ids);
        return "redirect:findAll";
    }

    @RequestMapping("/closeSta")
    public String closeSta(String[] ids){
        productService.closeSta(ids);
        return "redirect:findAll";
    }




}
