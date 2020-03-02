package com.mayikt.mapper;

import com.mayikt.entity.OrderInfo;
import com.mayikt.entity.OrderMaster;
import org.apache.ibatis.annotations.Insert;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrderMapper {
    @Insert("insert into order_master values (#{orderId},#{orderdesc},#{costs},#{date},#{status});")
    public int addOrder(@RequestParam OrderMaster orderMaster);
    @Insert("insert into order_info values (#{orderId},#{drugCode},#{drugSpec},#{price},#{num},#{status},#{unties});")
    public int addOrderInfo(OrderInfo orderInfo);
}
