package com.cxl.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: diancan
 * @Description: 产品显示类
 * @create: 2019-11-01 20:14
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductVO implements Serializable{

    /**
     * 产品id
     */
    private Integer id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品单价
     */
    private Long price;
}
