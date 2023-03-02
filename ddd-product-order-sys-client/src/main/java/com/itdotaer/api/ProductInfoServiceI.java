package com.itdotaer.api;

import com.alibaba.cola.dto.Response;
import com.itdotaer.dto.ProductDetailQueryCmd;
import com.itdotaer.dto.ProductQueryCmd;
import com.itdotaer.dto.ProductSaveCmd;

/**
 * ProductInfoServiceI
 *
 * @author jt_hu
 * @date 2021/9/15
 */
public interface ProductInfoServiceI {

    Response saveProductInfo(ProductSaveCmd productSaveCmd);

    Response queryProductInfo(ProductQueryCmd productQueryCmd);

    Response getProductDetail(ProductDetailQueryCmd productDetailQueryCmd);

}
