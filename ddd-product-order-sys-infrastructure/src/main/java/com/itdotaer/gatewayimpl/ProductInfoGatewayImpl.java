package com.itdotaer.gatewayimpl;

import com.itdotaer.convertor.ProductInfoConvertor;
import com.itdotaer.domain.gateway.ProductInfoGateway;
import com.itdotaer.domain.product.ProductInfo;
import com.itdotaer.gatewayimpl.database.Mybatis3Utils;
import com.itdotaer.gatewayimpl.database.ProductInfoMapper;
import com.itdotaer.gatewayimpl.database.dataobject.ProductInfoDO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

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
            Mybatis3Utils.closeCurrentSession();
        }
    }

    @Override
    public ProductInfo query(Long productId) {
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
