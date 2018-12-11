package cn.itcast.yyy.service.impl;

import cn.itcast.yyy.dao.UserDao;
import cn.itcast.yyy.domain.Role;
import cn.itcast.yyy.domain.UserInfo;
import cn.itcast.yyy.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * 用户权限登录
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true, true, true, true,getAuthorities(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
            list.add(sga);
        }

        return list;
    }

    /**
     * 查询所有的用户
     * @return
     * @param page
     * @param size
     */
    @Override
    public List<UserInfo> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return userDao.findAll();
    }

    /**
     * 添加用户
     * @param userInfo
     */
    @Override
    public void addUser(UserInfo userInfo) {
        //给当前的用户的密码进行加密
        String encode = bCryptPasswordEncoder.encode(userInfo.getPassword());
        //将加密好的密码重新设置到UserInfo
        userInfo.setPassword(encode);
        userDao.addUser(userInfo);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }


    /**
     * 根据id删除用户
     * @param id
     */
    @Override
    public void delById(String id) {
        userDao.delByUserId(id);
        userDao.delById(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String id : ids) {

            userDao.addRoleToUser(userId,id);
        }

    }
}
