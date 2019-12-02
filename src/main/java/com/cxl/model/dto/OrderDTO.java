package com.cxl.model.dto;

import com.cxl.model.basic.BasicInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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
public class OrderDTO implements Serializable {

    /**
     * 产品列表,id：产品序号、num：数量
     */
    private List<BasicInfo> productList;
}
