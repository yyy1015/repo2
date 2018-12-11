package cn.itcast.yyy.dao;

import cn.itcast.yyy.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(String id);


    @Select("select * from permission where id not in (select permissionId from ROLE_PERMISSION where roleId=#{id})")
    List<Permission> findOthersById(String id);


    @Select("select * from permission")
    List<Permission> findAll();


    @Select("insert into permission(permissionName,url) values (#{permissionName},#{url})")
    void addPermission(Permission permission);

    @Select("select * from permission where id = #{id}")
    Permission findById(String id);

    @Delete("delete from ROLE_PERMISSION where permissionId=#{id}")
    void delByRoleId(String id);

    @Delete("delete from PERMISSION where id=#{id}")
    void delById(String id);

    @Select("select * from permission where id = #{id}")
    Permission findById02(String id);

    @Update("update permission set permissionName=#{permissionName},url=#{url} where id = #{id}")
    void update(Permission permission);
}
