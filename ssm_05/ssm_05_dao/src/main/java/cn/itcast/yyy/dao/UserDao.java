package cn.itcast.yyy.dao;


import cn.itcast.yyy.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.yyy.dao.RoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username);


    /**
     *查询所有的用户
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll();

    /**
     * 添加用户
     * @param userInfo
     */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void addUser(UserInfo userInfo);


    /**
     * 根据用户id查询数据
     * @param id
     * @return
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.yyy.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id);




    /**
     * 根据id删除用户
     * @param id
     */
    @Delete("delete from users where id =#{id}")
    void delById(String id);

    @Delete("delete from users_role where userid=#{id}")
    void delByUserId(String id);


    @Insert("insert into users_role(userId,roleId) values (#{userId},#{id})")
    void addRoleToUser(@Param("userId") String userId, @Param("id") String id);
}
