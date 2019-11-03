package com.cxl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderInfo {
    private String orderId;

    private Integer userId;

    private Long amount;

    private Date addTime;

    private Integer status;

    private String remark;

    private Integer isEnable;

    @NoArgsConstructor
    @AllArgsConstructor
    public enum OrderInfoEnum {
        /**
         * 初始
         */
        INIT("初始", 1),
        /**
         * 进行中
         */
        DOING("进行中", 2),
        /**
         * 已完成
         */
        FINISH("已完成", 3);

        /**
         * 名称
         */
        private String name;

        /**
         * 类型
         */
        private Integer type;

        public String getName() {
            return this.name;
        }

        public Integer getType() {
            return this.type;
        }
    }
}