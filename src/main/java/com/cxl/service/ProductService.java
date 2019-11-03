package com.cxl.service;

import com.cxl.model.vo.PageVO;
import com.cxl.model.vo.ProductVO;
import org.hibernate.validator.constraints.Range;

/**
 * @program: diancan
 * @Description: 产品接口类
 * @create: 2019-11-01 20:19
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */
public interface ProductService {

    /**
     * 查询产品列表
     *
     * @param pageNum 页码
     * @param pageSize 条数
     * @return 产品列表
     */
    PageVO<ProductVO> getProductList(int pageNum,int pageSize);
}
