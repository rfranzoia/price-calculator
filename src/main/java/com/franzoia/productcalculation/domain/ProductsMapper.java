package com.franzoia.productcalculation.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsMapper {
    public static Products makeProduct(ProductsDTO dto) {
        return new Products(dto.getUuid(), dto.getName(), dto.getPrice());
    }

    public static ProductsDTO makeDTO(Products products) {
        ProductsDTO.ProductDTOBuilder productDTOBuilder = ProductsDTO.newBuilder()
                .setUuid(products.getUuid())
                .setName(products.getName())
                .setPrice(products.getPrice());

        return productDTOBuilder.createProductDTO();
    }

    public static List<ProductsDTO> makeListDTO(Collection<Products> products) {
        return products.stream()
                .map(ProductsMapper::makeDTO)
                .collect(Collectors.toList());
    }

    public static List<Products> makeList(Collection<ProductsDTO> productsDTO) {
        return productsDTO.stream()
                .map(ProductsMapper::makeProduct)
                .collect(Collectors.toList());
    }

}