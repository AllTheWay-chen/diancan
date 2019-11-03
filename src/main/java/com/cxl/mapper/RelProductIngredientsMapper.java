package com.cxl.mapper;

import com.cxl.model.RelProductIngredients;

public interface RelProductIngredientsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RelProductIngredients record);

    int insertSelective(RelProductIngredients record);

    RelProductIngredients selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RelProductIngredients record);

    int updateByPrimaryKey(RelProductIngredients record);
}