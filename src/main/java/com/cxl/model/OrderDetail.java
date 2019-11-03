package com.cxl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetail {
    private Integer id;

    private String orderId;

    private Integer productId;

    private String productName;

    private Integer productNum;

    private Long productPrice;
}