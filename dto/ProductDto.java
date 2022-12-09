package com.study.springboot202210sangwon.web.dto;

import lombok.*;

@Data
public class ProductDto {
    private String productCode;
    private String productName;
    private String price;
    private String stock;
}
//Param 으로 DTO 를 받으려면 @Data, getter setter 를 가지고 있어서 @Data 를 써야한다
