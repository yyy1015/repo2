package cn.itcast.yyy.service;

import cn.itcast.yyy.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有数据
     * @return
     * @param page
     * @param size
     */
    public List<Product> findAll(int page, int size);


    /**
     * 添加产品
     * @param product
     */
    public void saveProduct(Product product);

    /**
     * 根据id查新数据
     */
    public Product findById(String id);

    /**
     * 根据id删除
     * @param ids
     */
    void delById(String[] ids);

    /**
     * 根据name查询商品
     * @param cityName
     * @return
     */
    List<Product> findByName(String cityName);

    /**
     * 根据id修改状态
     * @param ids
     */
    void openSta(String[] ids);

    void closeSta(String[] ids);
}
