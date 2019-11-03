package com.cxl.model.qo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

/**
 * @program: diancan
 * @Description:
 * @create: 2019-11-01 20:10
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQO<T> {
    /**
     * 当前页号
     */
    @Range(min = 1, max = Integer.MAX_VALUE)
    private int pageNum = 1;

    /**
     * 一页数量
     */
    @Range(min = 1, max = Integer.MAX_VALUE)
    private int pageSize = 10;

    private T condition;

    public PageQO(int pageNum, int pageSize) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return (this.pageNum - 1) * this.pageSize;
    }

}
