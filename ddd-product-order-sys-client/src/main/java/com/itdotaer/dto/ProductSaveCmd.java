package com.itdotaer.dto;

import com.itdotaer.dto.data.ProductInfoDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ProductSaveCmd
 *
 * @author jt_hu
 * @date 2021/9/10
 */
@Data
public class ProductSaveCmd extends CommonCommand {

    @NotNull
    private ProductInfoDTO productInfoDTO;


}
