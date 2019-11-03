package com.cxl.mapper;

import com.cxl.model.Product;
import com.cxl.model.vo.ProductVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 查询产品列表
     *
     * @return 产品列表
     */
    List<ProductVO> selectProductList();
}