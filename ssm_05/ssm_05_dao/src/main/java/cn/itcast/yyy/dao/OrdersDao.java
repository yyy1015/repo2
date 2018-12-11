package cn.itcast.yyy.dao;

import cn.itcast.yyy.domain.Member;
import cn.itcast.yyy.domain.Orders;
import cn.itcast.yyy.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.itcast.yyy.dao.ProductDao.findById")),
    })
    public List<Orders> findAll02();


    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.itcast.yyy.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "cn.itcast.yyy.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = List.class,many = @Many(select = "cn.itcast.yyy.dao.TravellerDao.findById")),
    })
    public Orders findById(String id);



    @Delete("delete from orders where id =#{id}")
    public void delById(String id);

    @Select("select * from orders")
    List<Orders> findAll();

}
