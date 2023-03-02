package com.itdotaer.dto;

import com.itdotaer.dto.data.PageSettingDTO;
import com.itdotaer.dto.data.ProductQueryDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ProductSaveCmd
 *
 * @author jt_hu
 * @date 2021/9/10
 */
@Data
public class ProductQueryCmd extends CommonCommand {

    @NotNull
    private ProductQueryDTO query;

    @NotNull
    private PageSettingDTO page;


}
