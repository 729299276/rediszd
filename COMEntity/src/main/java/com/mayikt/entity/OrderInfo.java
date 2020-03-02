package com.mayikt.entity;

import lombok.Data;

@Data
public class OrderInfo {
    private String orderId;
    private String drugCode;
    private String drugSpec;
    private String unties;
    private Integer price;
    private Integer num;
    private int status;
}
