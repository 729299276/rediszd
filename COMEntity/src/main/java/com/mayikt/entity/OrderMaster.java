package com.mayikt.entity;

import lombok.Data;

import java.util.Date;
@Data
public class OrderMaster {
    private String orderId;
    private String orderdesc;
    private double costs;
    private Date date;
    private int status;
}
