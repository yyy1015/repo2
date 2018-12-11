package cn.itcast.yyy.controller;


import cn.itcast.yyy.domain.Permission;
import cn.itcast.yyy.domain.Role;
import cn.itcast.yyy.domain.UserInfo;
import cn.itcast.yyy.service.PermissionService;
import cn.itcast.yyy.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;


    /**
     * 查询所有角色
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) {
        ModelAndView mv = new ModelAndView();
        List<Role> list = roleService.findAll(page, size);
        PageInfo pg = new PageInfo(list);
        mv.addObject("roleList", pg);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 根据id查询用户
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }


    @RequestMapping("/findRoleByIdAndAllPer")
    public ModelAndView findRoleByIdAndAllPer(String id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        List<Permission> permissions = permissionService.findOthersById(id);
        mv.addObject("role", role);
        mv.addObject("permission", permissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(String roleId, String[] ids) {
        roleService.addPermissionToRole(roleId, ids);
        return "redirect:findAll";
    }


    /**
     * 添加角色
     */

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.addRole(role);
        return "redirect:findAll";
    }


    /**
     * 根据id查询角色,将角色信息返回到修改角色的页面
     */
    @RequestMapping("/findById02")
    public ModelAndView findById02(String id){
        ModelAndView mv = new ModelAndView();
        Role role1 = roleService.findById02(id);
        mv.addObject("role",role1);
        mv.setViewName("role-change");
        return mv;
    }

    @RequestMapping("/update")
    public String update(Role role){
        roleService.update(role);
        return "redirect:findAll";
    }


}
