package com.franzoia.productcalculation.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductsDTO {

    private Long uuid;

    private String name;

    private Double price;

    @JsonProperty
    public Long getUuid() {
        return uuid;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public Double getPrice() {
        return price;
    }

    private ProductsDTO(Long uuid, String name, Double price) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
    }

    public static ProductDTOBuilder newBuilder() {
        return new ProductDTOBuilder();
    }

    public static class ProductDTOBuilder {
        private Long uuid;

        private String name;

        private Double price;

        public ProductDTOBuilder setUuid(Long uuid) {
            this.uuid = uuid;
            return this;
        }

        public ProductDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductDTOBuilder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public ProductsDTO createProductDTO() {
            return new ProductsDTO(uuid, name, price);
        }
    }
}
