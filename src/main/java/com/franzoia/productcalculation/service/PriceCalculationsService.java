package com.franzoia.productcalculation.service;

import com.franzoia.productcalculation.domain.DiscountRulesDTO;
import com.franzoia.productcalculation.domain.PriceCalculationsDTO;
import com.franzoia.productcalculation.domain.Products;
import com.franzoia.productcalculation.enums.DiscountType;
import com.franzoia.productcalculation.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceCalculationsService {

    @Autowired
    static ProductsService productsService;

    @Autowired
    static DiscountRulesService discountRulesService;

    public static PriceCalculationsDTO singlePriceCalculation(PriceCalculationsDTO priceCalculationsDTO) {

        try {
            Products products = productsService.find(priceCalculationsDTO.getUuid());
            List<DiscountRulesDTO> discountRulesDTOS = discountRulesService.findByProduct(products.getUuid());

            Double totalPrice = calculateDiscount(priceCalculationsDTO.getQuantity(), products.getPrice(), discountRulesDTOS);

            return PriceCalculationsDTO.newBuilder()
                        .setUuid(priceCalculationsDTO.getUuid())
                        .setName(priceCalculationsDTO.getName())
                        .setPrice(priceCalculationsDTO.getPrice())
                        .setQuantity(priceCalculationsDTO.getQuantity())
                        .setTotalPrice(totalPrice)
                        .build();

        } catch (EntityNotFoundException enfe) {
            return PriceCalculationsDTO.newBuilder().build();
        }
    }

    public static List<PriceCalculationsDTO> multiplePriceCalculation(List<PriceCalculationsDTO> priceCalculationsDTOS) {

        // first normalize the list to remove duplicates
        HashMap<String, PriceCalculationsDTO> dtos = new HashMap<>();

        for (PriceCalculationsDTO dto : priceCalculationsDTOS) {
            if (dtos.get(dto.getUuid()) != null) {
                Long itemQuantity = dtos.get(dto.getUuid()).getQuantity();
                dtos.put(dto.getUuid(), PriceCalculationsDTO.newBuilder()
                                .setUuid(dto.getUuid())
                                .setQuantity(dto.getQuantity() + itemQuantity)
                                .build());

            }
        }

        return dtos.values().stream()
                .map(PriceCalculationsService::singlePriceCalculation)
                .collect(Collectors.toList());

    }

    private static Double calculateDiscount(Long quantity, Double price, List<DiscountRulesDTO> discountRulesDTOS) {
        Double totalPrice = quantity * price;

        Date today = new Date();

        if (discountRulesDTOS != null && discountRulesDTOS.size() > 0) {
            for (DiscountRulesDTO ruleDTO : discountRulesDTOS) {
                if (ruleDTO.getValidUntil().before(today))
                    continue;;

                if (ruleDTO.getDiscountType().equals(DiscountType.AMOUNT.toString())) {
                    if (quantity >= ruleDTO.getMinQuantity()) {
                        totalPrice -= ruleDTO.getAmount();
                    }
                } else if (ruleDTO.getDiscountType().equals(DiscountType.PERCENTAGE.toString())) {
                    totalPrice *= (ruleDTO.getAmount() / 100);
                }
            }
        }

        return totalPrice;
    }
}
