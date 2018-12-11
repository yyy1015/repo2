package cn.itcast.yyy.controller;


import cn.itcast.yyy.domain.Role;
import cn.itcast.yyy.domain.UserInfo;
import cn.itcast.yyy.service.RoleService;
import cn.itcast.yyy.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有的用户
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "4") Integer size){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list = userService.findAll(page,size);
        PageInfo pg = new PageInfo(list);
        mv.addObject("userList",pg);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(UserInfo userInfo){
        userService.addUser(userInfo);
        return "redirect:findAll";
    }

    /**
     * 根据id查询用户
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 根据id删除用户
     */

    @RequestMapping("/delById")
    public String delById(String id){
        userService.delById(id);
        return "redirect:findAll";
    }


    /**
     * 根据id查询user，并且根据id查询user下没有的角色
     * @param id
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id){
        ModelAndView mv = new ModelAndView();
        //根据id查询User
        UserInfo userInfo = userService.findById(id);
        //根据id查询user下没有的角色
        List<Role> roles = roleService.findOthersById(id);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 添加user没有的角色
     * 向users_role表中添加数据
     */
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId,String[] ids){
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll";
    }

}
