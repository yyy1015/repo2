package cn.itcast.yyy.service.impl;

import cn.itcast.yyy.dao.PermissionDao;
import cn.itcast.yyy.domain.Permission;
import cn.itcast.yyy.service.PermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findOthersById(String id) {
        return permissionDao.findOthersById(id);
    }

    @Override
    public List<Permission> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return permissionDao.findAll();
    }

    @Override
    public void addPermission(Permission permission) {
        permissionDao.addPermission(permission);
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }

    @Override
    public void delById(String id) {
        permissionDao.delByRoleId(id);
        permissionDao.delById(id);
    }

    @Override
    public Permission findById02(String id) {
        return permissionDao.findById02(id);
    }

    @Override
    public void update(Permission permission) {
        permissionDao.update(permission);
    }
}
