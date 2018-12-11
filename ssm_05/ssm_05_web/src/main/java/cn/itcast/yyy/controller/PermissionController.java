package cn.itcast.yyy.controller;


import cn.itcast.yyy.domain.Permission;
import cn.itcast.yyy.domain.Role;
import cn.itcast.yyy.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "3") Integer size){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(permissionList);
        mv.addObject("permissionList",pageInfo);
        mv.setViewName("permission-list");
        return  mv ;
    }

    @RequestMapping("/save")
    public String save(Permission permission) {
        System.out.println(permission);
        permissionService.addPermission(permission);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView mv = new ModelAndView();
        Permission p = permissionService.findById(id);
        mv.addObject("permission",p);
        mv.setViewName("permission-show");
        return mv;
    }

    /**
     * 根据id删除权限
     */
    @RequestMapping("/delById")
    public String delById(String id){
        permissionService.delById(id);
        return "redirect:findAll";
    }

    /**
     * 根据id查询permission
     */
    @RequestMapping("/findById02")
    public ModelAndView findById02(String id){
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionService.findById02(id);
        mv.addObject("permission",permission);
        mv.setViewName("permission-change");
        return mv;
    }

    /**
     * 修改权限信息
     */
    @RequestMapping("/update")
    public String update(Permission permission){
        permissionService.update(permission);
        return "redirect:findAll";
    }

}
