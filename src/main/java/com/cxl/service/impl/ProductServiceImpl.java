package com.cxl.service.impl;

import com.cxl.mapper.ProductMapper;
import com.cxl.model.vo.PageVO;
import com.cxl.model.vo.ProductVO;
import com.cxl.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: diancan
 * @Description: 产品实现类
 * @create: 2019-11-01 20:21
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public PageVO<ProductVO> getProductList(int pageNum, int pageSize) {
        Page<ProductVO> page = PageHelper.startPage(pageNum, pageSize);
        productMapper.selectProductList();
        return PageVO.build(page);
    }
}
