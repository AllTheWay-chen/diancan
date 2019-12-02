package com.cxl.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: diancan
 * @Description: 订单显示类
 * @create: 2019-11-03 21:21
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderVO implements Serializable{

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 订单金额
     */
    private Long amount;

    /**
     * 下单时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm", timezone = "GMT+8")
    private Date addTime;

    /**
     * 订单状态
     */
    private Integer status;
}
