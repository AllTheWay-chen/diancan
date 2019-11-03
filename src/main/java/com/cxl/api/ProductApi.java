package com.cxl.api;

import com.cxl.model.qo.PageQO;
import com.cxl.model.vo.PageVO;
import com.cxl.model.vo.ProductVO;
import com.cxl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @program: diancan
 * @Description: 产品API组
 * @create: 2019-11-01 19:57
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */
@RestController
@RequestMapping("/product")
public class ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public PageVO<ProductVO> getProductList(
            PageQO pageQO) {
        return productService.getProductList(pageQO.getPageNum(), pageQO.getPageSize());
    }
}
