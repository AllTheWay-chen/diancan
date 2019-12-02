package com.cxl.model.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xiaolong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicInfo implements Serializable {

    private Integer id;

    private Integer num;
}
