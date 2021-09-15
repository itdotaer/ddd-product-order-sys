package com.itdotaer.dto.data;

import lombok.Data;

@Data
public class ProductInfoDTO {
    private Long productId;

    private String productName;

    private Boolean online;

    private Boolean active;

    private Integer status;

    private String creator;

    private String modifier;
}
