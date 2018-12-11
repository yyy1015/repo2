package cn.itcast.yyy.controller;


import cn.itcast.yyy.domain.Orders;
import cn.itcast.yyy.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /**
     * 查询所有的数据
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = ordersService.findAll();
        mv.addObject("orders",orders);
        mv.setViewName("orders-list");
        return mv;
    }


    /**
     * 分页查询所有的数据
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll02")
    public ModelAndView findAll02(@RequestParam(name="page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "4") Integer size){
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll02(page,size);
        PageInfo pg = new PageInfo(ordersList);
        mv.addObject("pageInfo",pg);
        mv.setViewName("orders-list");
        return mv;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }


    /**
     * 根基订单id删除数据
     * @param id
     * @return
     */
    @RequestMapping("/delById")
    public String delById(String id){
        ordersService.delById(id);
        return "redirect:findAll02";
    }







}
