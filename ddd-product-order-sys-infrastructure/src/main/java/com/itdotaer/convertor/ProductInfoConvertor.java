package com.itdotaer.convertor;

import com.itdotaer.domain.product.ProductInfo;
import com.itdotaer.dto.data.ProductInfoDTO;
import com.itdotaer.gatewayimpl.database.dataobject.ProductInfoDO;
import org.springframework.beans.BeanUtils;

/**
 * ProductInfoConvertor
 *
 * @author jt_hu
 * @date 2021/9/10
 */
public class ProductInfoConvertor {

    public static ProductInfo toEntity(ProductInfoDTO productInfoDTO) {
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productInfoDTO, productInfo);
        return productInfo;
    }

    public static ProductInfoDO toDataObjectForCreate(ProductInfo productInfo) {
        ProductInfoDO productInfoDO = new ProductInfoDO();
        BeanUtils.copyProperties(productInfo, productInfoDO);
        return productInfoDO;
    }

    public static ProductInfoDO toDataObjectForUpdate(ProductInfo productInfo) {
        ProductInfoDO productInfoDO = new ProductInfoDO();
        BeanUtils.copyProperties(productInfo, productInfoDO);
        return productInfoDO;
    }

}
