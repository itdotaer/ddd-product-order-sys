package com.itdotaer.gatewayimpl.database;

import com.itdotaer.gatewayimpl.database.dataobject.ProductInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ProductInfoMapper
 *
 * @author jt_hu
 * @date 2021/9/10
 */
@Mapper
public interface ProductInfoMapper {

    int create(ProductInfoDO dataObject);

    int update(ProductInfoDO productInfoDO);

    int delete(@Param("modifier") String modifier, @Param("productId") Long productId);

    ProductInfoDO getById(@Param("region") String region, @Param("productId") Long productId);

    List<ProductInfoDO> query(@Param("region") String region, @Param("offset") Integer offset, @Param("size") Integer size);

}
