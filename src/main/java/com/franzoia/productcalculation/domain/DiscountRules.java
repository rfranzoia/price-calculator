package com.franzoia.productcalculation.domain;

import com.franzoia.productcalculation.enums.DiscountType;
import com.franzoia.productcalculation.util.DefaultEntity;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "discount_rules")
public class DiscountRules implements DefaultEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String discountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_uuid", nullable = false)
    private Products product;

    @Column(nullable = false)
    private Long minQuantity;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false, name = "valid_until")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date validUntil;

    public DiscountRules() {
    }

    public DiscountRules(Long id, String discountType, Products product, Long minQuantity, Double amount, Date validUntil) {
        this.id = id;
        this.discountType = discountType;
        this.product = product;
        this.minQuantity = minQuantity;
        this.amount = amount;
        this.validUntil = validUntil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Long getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Long minQuantity) {
        this.minQuantity = minQuantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountRules that = (DiscountRules) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
