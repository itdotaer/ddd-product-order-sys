package com.itdotaer.gatewayimpl;

import com.itdotaer.convertor.ProductInfoConvertor;
import com.itdotaer.domain.gateway.ProductInfoGateway;
import com.itdotaer.domain.product.ProductInfo;
import com.itdotaer.domain.product.QueryProductInfo;
import com.itdotaer.gatewayimpl.database.ProductInfoMapper;
import com.itdotaer.gatewayimpl.database.dataobject.ProductInfoDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * ProductInfoGatewayImpl
 *
 * @author jt_hu
 * @date 2021/9/10
 */
@Component
public class ProductInfoGatewayImpl implements ProductInfoGateway {

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Override
    public boolean save(ProductInfo productInfo) {
        if (Objects.isNull(productInfo.getProductId())) {
            // insert
            return productInfoMapper.create(ProductInfoConvertor.toDataObjectForCreate(productInfo)) > 0;
        }

        return productInfoMapper.update(ProductInfoConvertor.toDataObjectForUpdate(productInfo)) > 0;
    }

    @Override
    public QueryProductInfo query(Integer index, Integer size) {
        List<ProductInfoDO> productInfos = productInfoMapper.query((index - 1) * size, size);

        if (productInfos.isEmpty()) {
            return null;
        }

        QueryProductInfo queryProductInfo = new QueryProductInfo();
        queryProductInfo.setProductInfoList(productInfos.stream().map(productInfoDO -> {
            ProductInfo productInfo = new ProductInfo();
            BeanUtils.copyProperties(productInfoDO, productInfo);
            return productInfo;
        }).collect(Collectors.toList()));

        return queryProductInfo;
    }

    @Override
    public ProductInfo queryByProductId(Long productId) {
        ProductInfoDO productInfoDO = productInfoMapper.getById(productId);

        if (Objects.isNull(productInfoDO)) {
            return null;
        }

        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productInfoDO, productInfo);

        return productInfo;
    }

}
