package com.itdotaer.product.command;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.itdotaer.domain.gateway.ProductInfoGateway;
import com.itdotaer.domain.product.ProductInfo;
import com.itdotaer.domain.product.QueryProductInfo;
import com.itdotaer.dto.ProductQueryCmd;
import com.itdotaer.dto.data.PageSettingDTO;
import com.itdotaer.dto.data.ProductInfoDTO;
import com.itdotaer.dto.data.ProductQueryResultDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.stream.Collectors;

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
        QueryProductInfo queryProductInfo = productInfoGateway.query(cmd.getPage().getIndex(), cmd.getPage().getSize());
        if (Objects.isNull(queryProductInfo)) {
            return Response.buildFailure("N001", "product not exist");
        }

        ProductQueryResultDTO result = new ProductQueryResultDTO();

        PageSettingDTO page = cmd.getPage();
        page.setTotal(queryProductInfo.getTotal());
        result.setPage(page);

        result.setProductInfoList(queryProductInfo.getProductInfoList().stream().map(productInfo -> {
            ProductInfoDTO productInfoDTO = new ProductInfoDTO();
            BeanUtils.copyProperties(productInfo, productInfoDTO);
            return productInfoDTO;
        }).collect(Collectors.toList()));

        return SingleResponse.of(result);
    }

}
