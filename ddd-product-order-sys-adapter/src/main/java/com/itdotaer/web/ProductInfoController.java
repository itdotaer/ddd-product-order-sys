package com.itdotaer.web;

import com.alibaba.cola.dto.Response;
import com.itdotaer.api.ProductInfoServiceI;
import com.itdotaer.dto.ProductQueryCmd;
import com.itdotaer.dto.ProductSaveCmd;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ProductInfoController
 *
 * @author jt_hu
 * @date 2021/9/15
 */
@RestController(value = "/product")
public class ProductInfoController {

    @Resource
    private ProductInfoServiceI productInfoService;

    @RequestMapping("/save")
    public Response saveProduct(@RequestBody ProductSaveCmd productSaveCmd) {
        return productInfoService.saveProductInfo(productSaveCmd);
    }

    @RequestMapping("/query")
    public Response query(@RequestBody ProductQueryCmd productQueryCmd) {
        return productInfoService.queryProductInfo(productQueryCmd);
    }

}
