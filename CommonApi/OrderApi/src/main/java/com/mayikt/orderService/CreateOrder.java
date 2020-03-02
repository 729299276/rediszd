package com.mayikt.orderService;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.BaseResponse;
import com.mayikt.entity.OrderInfo;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface CreateOrder {
    @PostMapping("/createorder")
    public BaseResponse<JSONObject> createOrder(@RequestBody List<OrderInfo> orderInfos,String desc);

}
