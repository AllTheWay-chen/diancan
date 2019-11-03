package com.cxl.service.impl;

import com.cxl.mapper.OrderInfoMapper;
import com.cxl.mapper.ProductMapper;
import com.cxl.model.OrderInfo;
import com.cxl.model.Product;
import com.cxl.model.dto.OrderDTO;
import com.cxl.model.vo.OrderVO;
import com.cxl.service.OrderService;
import com.cxl.util.ConstantsUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: diancan
 * @Description: 订单实现类
 * @create: 2019-11-01 23:50
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */
@Service
@Log4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    private static Long total = 0L;

    @Override
    public Integer addOrder(OrderDTO orderDTO) {
        Map<Integer, Integer> productMap = orderDTO.getProductMap();
        Integer userId = (Integer) RequestContextHolder.getRequestAttributes().getAttribute("UserId", 0);
        if (null != productMap && !productMap.isEmpty()) {
            productMap.forEach((k, v) -> {
                Product product = productMapper.selectByPrimaryKey(k);
                if (null != product) {
                    total += product.getPrice() * v;
                }
            });
            OrderInfo orderInfo = OrderInfo.builder()
                    .orderId(UUID.randomUUID().toString())
                    .addTime(new Date())
                    .amount(total)
                    .userId(userId)
                    .status(OrderInfo.OrderInfoEnum.INIT.getType()).build();
            if (!ConstantsUtil.SUCCESS.equals(orderInfoMapper.insertSelective(orderInfo))) {
                log.error("下单失败");
                return ConstantsUtil.FAIL;
            }
        } else {
            log.error("订单不能为空");
            return ConstantsUtil.FAIL;
        }
        return ConstantsUtil.SUCCESS;
    }

    @Override
    public OrderVO getOrderById(String id) {
        OrderVO orderVO = new OrderVO();
        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(id);
        if (null == orderInfo) {
            log.error("订单未找到");
            return orderVO;
        }
        BeanUtils.copyProperties(orderInfo, orderVO);
        return orderVO;
    }

    @Override
    public List<OrderVO> getOrderList(OrderInfo orderInfo) {
        return orderInfoMapper.selectOrderList(orderInfo);
    }

    @Override
    public Integer updOrder(String id, OrderDTO orderDTO) {
        OrderInfo orderInfo = OrderInfo.builder()
                .orderId(id).build();
        BeanUtils.copyProperties(orderDTO, orderInfo);
        if (!ConstantsUtil.SUCCESS.equals(orderInfoMapper.updateByPrimaryKeySelective(orderInfo))) {
            log.error("订单修改失败");
            return ConstantsUtil.FAIL;
        }
        return ConstantsUtil.SUCCESS;
    }
}
