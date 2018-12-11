package cn.itcast.yyy.dao;

import cn.itcast.yyy.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductDao {

    @Select("select * from product")
    public List<Product> findAll();

    @Insert("insert into product(productnum, productname, cityname, departuretime, productprice,productdesc, productstatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void saveProduct(Product product);

    @Select("select * from product where id = #{id}")
    public Product findById(String id);

    @Delete("delete from product where id = #{id}")
    void delById(String id);

    @Delete("delete from orders where productid = #{id}")
    void delByProId(String id);

    @Select("select * from product where cityName =#{cityName}")
    List<Product> findByName(String cityName);


    @Update("update product set productStatus=1 where id = #{id}")
    void openSta(String id);

    @Update("update product set productStatus=0 where id = #{id}")
    void closeSta(String id);
}
