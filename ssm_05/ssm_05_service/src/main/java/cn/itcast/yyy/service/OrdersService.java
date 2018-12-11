package cn.itcast.yyy.service;

import cn.itcast.yyy.domain.Orders;

import java.util.List;

public interface OrdersService {

    public List<Orders> findAll02(int page, int size);

    /**
     * 根据id查询数据
     */
    public Orders findById(String id);

    /**
     * 根据id删除数据
     *
     */
    public void delById(String id);

    List<Orders> findAll();
}
