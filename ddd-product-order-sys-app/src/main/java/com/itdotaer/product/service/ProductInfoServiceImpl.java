package com.itdotaer.product.service;

import com.alibaba.cola.dto.Response;
import com.itdotaer.api.ProductInfoServiceI;
import com.itdotaer.dto.ProductDetailQueryCmd;
import com.itdotaer.dto.ProductQueryCmd;
import com.itdotaer.dto.ProductSaveCmd;
import com.itdotaer.product.command.ProductDetailQueryCmdExe;
import com.itdotaer.product.command.ProductQueryCmdExe;
import com.itdotaer.product.command.ProductSaveCmdExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ProductInfoServiceImpl
 *
 * @author jt_hu
 * @date 2021/9/15
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoServiceI {

    @Resource
    private ProductSaveCmdExe productSaveCmdExe;
    @Resource
    private ProductQueryCmdExe productQueryCmdExe;
    @Resource
    private ProductDetailQueryCmdExe productDetailQueryCmdExe;

    @Override
    public Response saveProductInfo(ProductSaveCmd productSaveCmd) {
        return productSaveCmdExe.execute(productSaveCmd);
    }

    @Override
    public Response queryProductInfo(ProductQueryCmd productQueryCmd) {
        return productQueryCmdExe.execute(productQueryCmd);
    }

    @Override
    public Response getProductDetail(ProductDetailQueryCmd productDetailQueryCmd) {
        return productDetailQueryCmdExe.execute(productDetailQueryCmd);
    }
}
