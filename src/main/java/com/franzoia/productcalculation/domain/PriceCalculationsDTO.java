package com.franzoia.productcalculation.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceCalculationsDTO {

    private String uuid;

    private String name;

    private Double price;

    private Long quantity;

    private Double totalPrice;

    @JsonProperty
    public String getUuid() {
        return uuid;
    }

    @JsonProperty(required = false)
    public String getName() {
        return name;
    }

    @JsonProperty(required = false)
    public Double getPrice() {
        return price;
    }

    @JsonProperty
    public Long getQuantity() {
        return quantity;
    }

    @JsonProperty(required = false)
    public Double getTotalPrice() {
        return totalPrice;
    }

    private PriceCalculationsDTO(String uuid, Long quantity, Double totalPrice) {
        this.uuid = uuid;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public static ProductCalculationDTOBuilder newBuilder() {
        return new ProductCalculationDTOBuilder();
    }
    public static class ProductCalculationDTOBuilder {
        private String uuid;

        private String name;

        private Double price;

        private Long quantity;

        private Double totalPrice;

        public ProductCalculationDTOBuilder setUuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public ProductCalculationDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductCalculationDTOBuilder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public ProductCalculationDTOBuilder setQuantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductCalculationDTOBuilder setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public PriceCalculationsDTO build() {
            return new PriceCalculationsDTO(uuid, quantity, totalPrice);
        }
    }
}
