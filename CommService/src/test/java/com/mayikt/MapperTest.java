package com.mayikt;

import com.mayikt.entity.OrderInfo;
import com.mayikt.entity.OrderMaster;
import com.mayikt.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApp.class)
public class MapperTest {
    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void testAdd(){
        OrderMaster orderMaster = new OrderMaster();
        String nextId = SnowflakeIdUtils.nextId();
        orderMaster.setOrderId(nextId);
        orderMaster.setCosts(100);
        orderMaster.setOrderdesc("单元测试");
        orderMaster.setDate(new Date());
        orderMaster.setStatus(1);
        int orderMaster1 = orderMapper.addOrder(orderMaster);
        System.out.println("插入成功："+orderMaster1);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(nextId);
        orderInfo.setDrugCode("sf8855");
        orderInfo.setDrugSpec("123");
        orderInfo.setNum(1);
        orderInfo.setStatus(1);
        orderInfo.setUnties("片");
        int i = orderMapper.addOrderInfo(orderInfo);

    }
}
