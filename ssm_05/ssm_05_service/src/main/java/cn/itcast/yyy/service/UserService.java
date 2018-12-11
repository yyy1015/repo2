package cn.itcast.yyy.service;

import cn.itcast.yyy.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    /**
     * 查询所有的用户
     * @return
     * @param page
     * @param size
     */
    List<UserInfo> findAll(int page, int size);


    /**
     * 添加用户
     */
    void addUser(UserInfo userInfo);


    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    UserInfo findById(String id);

    void delById(String id);

    void addRoleToUser(String userId, String[] ids);
}
