package com.mayikt.service;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.BaseApiService;
import com.mayikt.BaseResponse;
import com.mayikt.SnowflakeIdUtils;
import com.mayikt.SnowflakeIdWorker;
import com.mayikt.entity.OrderInfo;
import com.mayikt.entity.OrderMaster;
import com.mayikt.mapper.OrderMapper;
import com.mayikt.orderService.CreateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class OrderService  extends BaseApiService<JSONObject> implements CreateOrder {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TestService testService;
    @Override
    public BaseResponse<JSONObject> createOrder(@RequestBody List<OrderInfo> orderInfos,String desc) {
        //1.先生成订单
        OrderMaster orderMaster = new OrderMaster();
        String nextId = SnowflakeIdUtils.nextId();
        orderMaster.setOrderId(nextId);
        orderMaster.setStatus(0);
        orderMaster.setOrderdesc(desc);
        Integer sum=0;
        for(OrderInfo orderInfo:orderInfos){
            orderInfo.setOrderId(nextId);
            orderMapper.addOrderInfo(orderInfo);
            sum+=orderInfo.getPrice()*orderInfo.getNum();
        }
        testService.teste();
        orderMaster.setDate(new Date());
        orderMaster.setCosts(sum);
        orderMaster.setCosts(sum);
        orderMapper.addOrder(orderMaster);
        redisTemplate.opsForValue().set(nextId,"123",15, TimeUnit.SECONDS);
        return setResultSuccess("添加成功！");
    }
}
