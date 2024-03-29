package com.itdotaer.domain.gateway;

import com.itdotaer.domain.product.ProductInfo;
import com.itdotaer.domain.product.QueryProductInfo;

/**
 * ProductInfoGateway
 *
 * @author jt_hu
 * @date 2021/9/10
 */
public interface ProductInfoGateway {

    boolean save(ProductInfo productInfo);

    QueryProductInfo query(String region, Integer index, Integer size);

    ProductInfo queryByProductId(String region, Long productId);

}
