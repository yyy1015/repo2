package cn.itcast.yyy.service.impl;

import cn.itcast.yyy.dao.RoleDao;
import cn.itcast.yyy.domain.Role;
import cn.itcast.yyy.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    /**
     * 查询所有的角色
     * @return
     * @param page
     * @param size
     */
    @Override
    public List<Role> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public List<Role> findOthersById(String id) {
        return roleDao.findOthersById(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        for (String id : ids) {
            roleDao.addPermissionToRole(roleId,id);
        }
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role findById02(String id) {
        return roleDao.findById02(id);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }
}
