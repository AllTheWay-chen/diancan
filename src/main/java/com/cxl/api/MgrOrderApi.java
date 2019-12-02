package com.cxl.api;

import com.cxl.model.OrderInfo;
import com.cxl.model.dto.OrderDTO;
import com.cxl.model.vo.OrderVO;
import com.cxl.service.OrderService;
import com.cxl.util.annotations.AvoidRepeatableCommit;
import io.swagger.annotations.ApiOperationSort;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: diancan
 * @Description: 订单API组
 * @create: 2019-11-03 21:34
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */
@RestController
@RequestMapping("/mgr/order")
public class MgrOrderApi {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderVO> getOrderList(
            OrderInfo orderInfo
    ) {
        return orderService.getOrderList(orderInfo);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Integer updOrder(
            @NotBlank(message = "订单号不能为空")
            @PathVariable String id,
            OrderDTO orderDTO) {
        return orderService.updOrder(id,orderDTO);
    }
}
