package com.franzoia.productcalculation.service;

import com.franzoia.productcalculation.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculationsService {

    @Autowired
    ProductsService productsService;

    @Autowired
    DiscountRulesService discountRulesService;

}
