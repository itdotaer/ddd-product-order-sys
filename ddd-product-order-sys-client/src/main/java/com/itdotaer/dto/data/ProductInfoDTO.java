package com.itdotaer.dto.data;

import com.itdotaer.annotation.Region;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class ProductInfoDTO {

    private Long productId;

    @NotNull(message = "region couldn't be empty")
    @Region(value = {"tw","sg"})
    private String region;

    private String productName;

    private Boolean online;

    private Boolean active;

    private Integer status;

    private String creator;

    private String modifier;
}
