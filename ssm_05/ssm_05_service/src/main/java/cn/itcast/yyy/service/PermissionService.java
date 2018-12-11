package cn.itcast.yyy.service;

import cn.itcast.yyy.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findOthersById(String id);

    List<Permission> findAll(int page, int size);

    void addPermission(Permission permission);

    Permission findById(String id);

    void delById(String id);

    Permission findById02(String id);

    void update(Permission permission);
}
