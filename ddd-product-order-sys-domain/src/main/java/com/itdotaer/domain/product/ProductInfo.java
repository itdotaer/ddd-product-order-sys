package com.itdotaer.domain.product;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

/**
 * ProductInfo
 *
 * @author jt_hu
 * @date 2021/9/10
 */
@Data
@Entity
public class ProductInfo {

    private Long productId;

    private String region;

    private String productName;

    private Boolean online;

    private Boolean active;

    private Integer status;

    private String creator;

    private String modifier;

}
