package cn.itcast.yyy.service;

import cn.itcast.yyy.domain.Role;

import java.util.List;

public interface RoleService {

    /**
     * 查询所有的角色
     * @return
     * @param page
     * @param size
     */
    List<Role> findAll(int page, int size);

    Role findById(String id);

    List<Role> findOthersById(String id);

    void addPermissionToRole(String roleId, String[] ids);

    void addRole(Role role);

    Role findById02(String id);

    void update(Role role);
}
