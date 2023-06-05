package com.franzoia.productcalculation.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductsDTO {

    private String uuid;

    private String name;

    private Double price;

    @JsonProperty
    public String getUuid() {
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

    private ProductsDTO(String uuid, String name, Double price) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
    }

    public static ProductDTOBuilder newBuilder() {
        return new ProductDTOBuilder();
    }

    public static class ProductDTOBuilder {
        private String uuid;

        private String name;

        private Double price;

        public ProductDTOBuilder setUuid(String uuid) {
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
