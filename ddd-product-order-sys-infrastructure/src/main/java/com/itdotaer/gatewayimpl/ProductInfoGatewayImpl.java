package com.itdotaer.gatewayimpl;

import com.itdotaer.convertor.ProductInfoConvertor;
import com.itdotaer.domain.gateway.ProductInfoGateway;
import com.itdotaer.domain.product.ProductInfo;
import com.itdotaer.domain.product.QueryProductInfo;
import com.itdotaer.gatewayimpl.database.Mybatis3Utils;
import com.itdotaer.gatewayimpl.database.ProductInfoMapper;
import com.itdotaer.gatewayimpl.database.dataobject.ProductInfoDO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
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

    @Override
    public boolean save(ProductInfo productInfo) {
        SqlSession sqlSession = Mybatis3Utils.getCurrentSqlSession();
        ProductInfoMapper productInfoMapper = sqlSession.getMapper(ProductInfoMapper.class);

        try {
            if (Objects.isNull(productInfo.getProductId())) {
                // insert
                return productInfoMapper.create(ProductInfoConvertor.toDataObjectForCreate(productInfo)) > 0;
            }

            return productInfoMapper.update(ProductInfoConvertor.toDataObjectForUpdate(productInfo)) > 0;
        } finally {
            sqlSession.commit();
            Mybatis3Utils.closeCurrentSession();
        }
    }

    @Override
    public QueryProductInfo query(Integer index, Integer size) {
        SqlSession sqlSession = Mybatis3Utils.getCurrentSqlSession();
        ProductInfoMapper productInfoMapper = sqlSession.getMapper(ProductInfoMapper.class);

        try {
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
        } finally {
            Mybatis3Utils.closeCurrentSession();
        }
    }

    @Override
    public ProductInfo queryByProductId(Long productId) {
        SqlSession sqlSession = Mybatis3Utils.getCurrentSqlSession();
        ProductInfoMapper productInfoMapper = sqlSession.getMapper(ProductInfoMapper.class);

        try {
            ProductInfoDO productInfoDO = productInfoMapper.getById(productId);

            if (Objects.isNull(productInfoDO)) {
                return null;
            }

            ProductInfo productInfo = new ProductInfo();
            BeanUtils.copyProperties(productInfoDO, productInfo);

            return productInfo;
        } finally {
            Mybatis3Utils.closeCurrentSession();
        }
    }

}
