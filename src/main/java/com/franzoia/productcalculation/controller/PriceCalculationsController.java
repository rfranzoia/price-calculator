package com.franzoia.productcalculation.controller;

import com.franzoia.productcalculation.domain.PriceCalculationsDTO;
import com.franzoia.productcalculation.service.PriceCalculationsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price-calculation")
public class PriceCalculationsController {

    @PostMapping(value = "/product-item")
    public PriceCalculationsDTO get(@Validated @RequestBody final PriceCalculationsDTO priceCalculationsDTO) {
        return PriceCalculationsService.singlePriceCalculation(priceCalculationsDTO);
    }

    @PostMapping(value = "/product-list")
    public List<PriceCalculationsDTO> list(@Validated @RequestBody final List<PriceCalculationsDTO> priceCalculationsDTOS) {
        return PriceCalculationsService.multiplePriceCalculation(priceCalculationsDTOS);
    }

    @GetMapping(value = "/product/{uuid}/quantity/{quantity}")
    public PriceCalculationsDTO getByUuidAndPrice(@PathVariable("uuid") final String uuid, @PathVariable("quantity") final Long quantity) {
        PriceCalculationsDTO dto = PriceCalculationsDTO.newBuilder()
                .setUuid(uuid)
                .setQuantity(quantity)
                .build();

        return PriceCalculationsService.singlePriceCalculation(dto);
    }
}
