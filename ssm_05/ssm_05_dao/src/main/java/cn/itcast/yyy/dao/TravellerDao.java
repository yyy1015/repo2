package cn.itcast.yyy.dao;

import cn.itcast.yyy.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {


    @Select("select * from traveller where id in (select travellerid from order_traveller where orderid=#{orderid})")
    public List<Traveller> findById(String id);
}
