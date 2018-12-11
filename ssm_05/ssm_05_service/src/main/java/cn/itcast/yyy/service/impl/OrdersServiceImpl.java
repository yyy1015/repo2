package cn.itcast.yyy.service.impl;

import cn.itcast.yyy.dao.OrdersDao;
import cn.itcast.yyy.domain.Orders;
import cn.itcast.yyy.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    /**
     * 分页查询所有数据
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Orders> findAll02(int page, int size) {

        PageHelper.startPage(page,size);
        return ordersDao.findAll02();
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public Orders findById(String id){
        return ordersDao.findById(id);
    }

    /**
     * 根据id删除数据
     * @param id
     */
    @Override
    public void delById(String id) {
        ordersDao.delById(id);
    }

    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }
}
