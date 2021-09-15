package com.itdotaer.product.command;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.itdotaer.domain.gateway.ProductInfoGateway;
import com.itdotaer.domain.product.ProductInfo;
import com.itdotaer.dto.ProductQueryCmd;
import com.itdotaer.dto.data.ProductInfoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * ProductSaveCmdExe
 *
 * @author jt_hu
 * @date 2021/9/10
 */
@Component
public class ProductQueryCmdExe {

    @Resource
    private ProductInfoGateway productInfoGateway;

    public Response execute(ProductQueryCmd cmd) {
        ProductInfo productInfo = productInfoGateway.query(cmd.getProductId());
        if (Objects.isNull(productInfo)) {
            return Response.buildFailure("N001", "product not exist");
        }

        ProductInfoDTO productInfoDTO = new ProductInfoDTO();
        BeanUtils.copyProperties(productInfo, productInfoDTO);

        return SingleResponse.of(productInfoDTO);
    }

}
