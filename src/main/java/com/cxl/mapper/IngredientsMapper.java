package com.cxl.mapper;

import com.cxl.model.Ingredients;

public interface IngredientsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ingredients record);

    int insertSelective(Ingredients record);

    Ingredients selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ingredients record);

    int updateByPrimaryKey(Ingredients record);
}