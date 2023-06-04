package com.franzoia.productcalculation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.franzoia.productcalculation.enums.DiscountType;

import java.util.Date;

public class DiscountRulesDTO {

    private Long id;
    private String discountType;
    private ProductsDTO product;
    private Long minQuantity;
    private Double amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date validUntil;

    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonProperty
    public String getDiscountType() {
        return discountType;
    }

    @JsonProperty
    public ProductsDTO getProduct() {
        return product;
    }

    @JsonProperty
    public Long getMinQuantity() {
        return minQuantity;
    }

    public Double getAmount() {
        return amount;
    }

    @JsonProperty
    public Date getValidUntil() {
        return validUntil;
    }

    private DiscountRulesDTO(Long id, String discountType, ProductsDTO product, Long minQuantity, Double amount, Date validUntil) {
        this.id = id;
        this.discountType = discountType;
        this.product = product;
        this.minQuantity = minQuantity;
        this.amount = amount;
        this.validUntil = validUntil;
    }

    public static DiscountRulesDTOBuilder newBuilder() {
        return new DiscountRulesDTOBuilder();
    }

    public static class DiscountRulesDTOBuilder {
        private Long id;
        private String discountType;
        private ProductsDTO product;
        private Long minQuantity;
        private Double amount;
        private Date validUntil;

        public DiscountRulesDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public DiscountRulesDTOBuilder setDiscountType(String discountType) {
            this.discountType = discountType;
            return this;
        }

        public DiscountRulesDTOBuilder setProduct(ProductsDTO product) {
            this.product = product;
            return this;
        }

        public DiscountRulesDTOBuilder setMinQuantity(Long minQuantity) {
            this.minQuantity = minQuantity;
            return this;
        }

        public DiscountRulesDTOBuilder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public DiscountRulesDTOBuilder setValidUntil(Date validUntil) {
            this.validUntil = validUntil;
            return this;
        }

        public DiscountRulesDTO createDiscountRulesDTO() {
            return new DiscountRulesDTO(id, discountType, product, minQuantity, amount, validUntil);
        }
    }
}
