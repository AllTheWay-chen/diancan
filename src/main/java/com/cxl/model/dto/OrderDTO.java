package com.cxl.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: diancan
 * @Description:
 * @create: 2019-11-01 23:44
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO implements Serializable{

    /**
     * 产品列表,k：订单号、v：数量
     */
    private Map<Integer,Integer> productMap;
}
