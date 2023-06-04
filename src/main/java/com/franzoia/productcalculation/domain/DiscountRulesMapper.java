package com.franzoia.productcalculation.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountRulesMapper {

    public static DiscountRules makeDiscountRules(DiscountRulesDTO dto) {
        return new DiscountRules(dto.getId(),
                dto.getDiscountType(),
                ProductsMapper.makeProduct(dto.getProduct()),
                dto.getMinQuantity(),
                dto.getAmount(),
                dto.getValidUntil());
    }

    public static DiscountRulesDTO makeDTO(DiscountRules discountRules) {
        DiscountRulesDTO.DiscountRulesDTOBuilder builder = DiscountRulesDTO.newBuilder()
                .setId(discountRules.getId())
                .setProduct(ProductsMapper.makeDTO(discountRules.getProduct()))
                .setDiscountType(discountRules.getDiscountType())
                .setMinQuantity(discountRules.getMinQuantity())
                .setAmount(discountRules.getAmount())
                .setValidUntil(discountRules.getValidUntil());
        return builder.createDiscountRulesDTO();
    }

    public static List<DiscountRulesDTO> makeListDTO(Collection<DiscountRules> discountRules) {
        return discountRules.stream()
                .map(DiscountRulesMapper::makeDTO)
                .collect(Collectors.toList());
    }

    public static List<DiscountRules> makeList(Collection<DiscountRulesDTO> discountRulesDTOS) {
        return discountRulesDTOS.stream()
                .map(DiscountRulesMapper::makeDiscountRules)
                .collect(Collectors.toList());
    }
}
