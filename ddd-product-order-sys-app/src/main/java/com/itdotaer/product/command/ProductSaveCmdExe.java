package com.itdotaer.product.command;

import com.alibaba.cola.dto.Response;
import com.itdotaer.convertor.ProductInfoConvertor;
import com.itdotaer.domain.gateway.ProductInfoGateway;
import com.itdotaer.domain.product.ProductInfo;
import com.itdotaer.dto.ProductSaveCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ProductSaveCmdExe
 *
 * @author jt_hu
 * @date 2021/9/10
 */
@Component
public class ProductSaveCmdExe {

    @Resource
    private ProductInfoGateway productInfoGateway;

    public Response execute(ProductSaveCmd cmd) {
        ProductInfo productInfo = ProductInfoConvertor.toEntity(cmd.getProductInfoDTO());
        productInfoGateway.save(productInfo);
        return Response.buildSuccess();
    }

}
