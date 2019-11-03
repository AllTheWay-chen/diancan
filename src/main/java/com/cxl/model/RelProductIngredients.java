package com.cxl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelProductIngredients {
    private Integer id;

    private Integer productId;

    private Integer ingredientsId;

    private Integer isEnable;
}