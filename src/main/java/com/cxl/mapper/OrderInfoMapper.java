package com.cxl.mapper;

import com.cxl.model.OrderInfo;
import com.cxl.model.vo.OrderVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    /**
     * 查询订单列表
     * @param orderInfo 订单信息
     *
     * @return 订单列表
     */
    List<OrderVO> selectOrderList(OrderInfo orderInfo);
}