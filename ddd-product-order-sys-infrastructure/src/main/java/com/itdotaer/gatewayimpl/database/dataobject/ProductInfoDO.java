package com.itdotaer.gatewayimpl.database.dataobject;

import lombok.Data;

/**
 * ProductInfoDO
 *
 * @author jt_hu
 * @date 2021/9/15
 */
@Data
public class ProductInfoDO {

    private Long productId;

    private String region;

    private String productName;

    private Boolean online;

    private Boolean active;

    private Integer status;

    private String creator;

    private String modifier;
}
