package com.grupo3.vilayara.dtos;

import org.springframework.lang.Nullable;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class ProductDTO {
 
    private String name;
    private String productsCategory;
    private String description;
    @Nullable
    private int quantity;
    @Nullable
    private double unitaryPrice;
    private String imageUrl;

}
