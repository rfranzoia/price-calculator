package com.franzoia.productcalculation.repository;

import com.franzoia.productcalculation.domain.DiscountRules;
import com.franzoia.productcalculation.domain.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface DiscountRulesRepository extends CrudRepository<DiscountRules, Long> {

    List<DiscountRules> findByProduct(Products products);

    List<DiscountRules> findByValidUntilAfter(Date validUntil);
}
