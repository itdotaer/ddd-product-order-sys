package com.itdotaer.domain.product;

import lombok.Data;

import java.util.List;

@Data
public class QueryProductInfo {
    private List<ProductInfo> productInfoList;
    private Integer total;
}
