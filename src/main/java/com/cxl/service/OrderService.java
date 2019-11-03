package com.cxl.service;

import com.cxl.model.OrderInfo;
import com.cxl.model.dto.OrderDTO;
import com.cxl.model.vo.OrderVO;

import java.util.List;

/**
 * @program: diancan
 * @Description: 订单接口类
 * @create: 2019-11-01 23:41
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */
public interface OrderService {

    /**
     * 新增订单
     *
     * @param orderDTO 订单dto
     * @return 标识位
     */
    Integer addOrder(OrderDTO orderDTO);

    /**
     * 查询订单状态信息
     *
     * @param id 订单号
     * @return 订单信息
     */
    OrderVO getOrderById(String id);

    /**
     * 查询订单列表
     * @param orderInfo 订单信息
     *
     * @return 订单列表
     */
    List<OrderVO> getOrderList(OrderInfo orderInfo);

    /**
     * 修改订单信息
     *
     * @param id 订单id
     * @param orderDTO 订单信息
     * @return 标识位
     */
    Integer updOrder(String id, OrderDTO orderDTO);
}
