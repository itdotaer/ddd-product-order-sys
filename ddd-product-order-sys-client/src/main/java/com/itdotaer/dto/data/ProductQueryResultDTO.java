package com.itdotaer.dto.data;

import lombok.Data;

import java.util.List;

@Data
public class ProductQueryResultDTO {
    private List<ProductInfoDTO> productInfoList;
    private PageSettingDTO page;
}
