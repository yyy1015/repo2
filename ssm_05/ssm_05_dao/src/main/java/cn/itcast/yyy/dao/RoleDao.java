package cn.itcast.yyy.dao;

import cn.itcast.yyy.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permission",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.yyy.dao.PermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId);


    /**
     * 查询所有的角色
     * @return
     */
    @Select("select * from role")
    List<Role> findAll();


    @Select("select * from role where id =#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permission",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.yyy.dao.PermissionDao.findPermissionByRoleId"))
    })
    Role findById(String id);


    @Select("select * from role where id not in (select roleId from users_role where userId=#{id})")
    List<Role> findOthersById(String id);


    @Insert("insert into ROLE_PERMISSION(permissionId,roleId) values (#{id},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("id") String id);

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void addRole(Role role);


    @Select("select * from role where id =#{id}")
    Role findById02(String id);


    @Update("update role set roleName=#{roleName},roleDesc=#{roleDesc} where id = #{id}")
    void update(Role role);
}
