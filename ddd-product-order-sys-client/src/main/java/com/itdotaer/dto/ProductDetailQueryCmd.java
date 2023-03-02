package com.itdotaer.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ProductDetailQueryCmd
 *
 * @author jt_hu
 * @date 2021/9/10
 */
@Data
public class ProductDetailQueryCmd extends CommonCommand {

    @NotNull
    private Long productId;


}
