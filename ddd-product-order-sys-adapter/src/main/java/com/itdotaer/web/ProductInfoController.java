package com.itdotaer.web;

import com.alibaba.cola.dto.Response;
import com.itdotaer.api.ProductInfoServiceI;
import com.itdotaer.dto.ProductDetailQueryCmd;
import com.itdotaer.dto.ProductQueryCmd;
import com.itdotaer.dto.ProductSaveCmd;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * ProductInfoController
 *
 * @author jt_hu
 * @date 2021/9/15
 */
@RestController
@RequestMapping(value = "/product")
public class ProductInfoController {

    @Resource
    private ProductInfoServiceI productInfoService;

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public Response saveProduct(@RequestBody ProductSaveCmd productSaveCmd) {
        return productInfoService.saveProductInfo(productSaveCmd);
    }

    @RequestMapping(method =  RequestMethod.POST, path = "/query")
    public Response productQuery(@RequestBody ProductQueryCmd productQueryCmd) {
        return productInfoService.queryProductInfo(productQueryCmd);
    }

    @RequestMapping(method =  RequestMethod.GET, path = "/detail/{product_id}")
    public Response productDetail(@PathVariable("product_id") @NotNull Long productId) {
        ProductDetailQueryCmd productDetailQueryCmd = new ProductDetailQueryCmd();
        productDetailQueryCmd.setProductId(productId);

        return productInfoService.getProductDetail(productDetailQueryCmd);
    }

}
