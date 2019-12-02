package com.cxl.api;

import com.cxl.model.dto.OrderDTO;
import com.cxl.model.vo.OrderVO;
import com.cxl.service.OrderService;
import com.cxl.util.annotations.AvoidRepeatableCommit;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @program: diancan
 * @Description: 订单API组
 * @create: 2019-11-01 23:40
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */
@RestController
@RequestMapping("/order")
public class OrderApi {

    @Autowired
    private OrderService orderService;

    @AvoidRepeatableCommit
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public Integer addOrder(
            @RequestBody
            OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderVO addOrder(
            @NotBlank(message = "订单号不能为空")
            @PathVariable String id) {
        return orderService.getOrderById(id);
    }
}
