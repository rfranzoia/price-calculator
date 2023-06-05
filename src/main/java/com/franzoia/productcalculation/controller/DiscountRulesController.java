package com.franzoia.productcalculation.controller;

import com.franzoia.productcalculation.domain.DiscountRulesDTO;
import com.franzoia.productcalculation.domain.DiscountRulesMapper;
import com.franzoia.productcalculation.exception.ConstraintsViolationException;
import com.franzoia.productcalculation.exception.EntityNotFoundException;
import com.franzoia.productcalculation.service.DiscountRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/discount-rules")
public class DiscountRulesController {

    private DiscountRulesService discountRulesService;

    @Autowired
    public DiscountRulesController(final DiscountRulesService discountRulesService) {
        this.discountRulesService = discountRulesService;
    }

    public List<DiscountRulesDTO> findAll() {
        return DiscountRulesMapper.makeListDTO(discountRulesService.findAll());
    }

    @GetMapping(value = "/{id}")
    public DiscountRulesDTO get(@PathVariable("id") final Long id) throws EntityNotFoundException {
        return DiscountRulesMapper.makeDTO(discountRulesService.find(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DiscountRulesDTO create(@Validated @RequestBody final DiscountRulesDTO discountRulesDTO) throws ConstraintsViolationException {
        return discountRulesService.create(discountRulesDTO);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") final Long id, @RequestBody final DiscountRulesDTO discountRulesDTO) throws EntityNotFoundException {
        discountRulesService.update(id, discountRulesDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) throws EntityNotFoundException {
        discountRulesService.delete(id);
    }

    @GetMapping(value = "/validUntilToday")
    public List<DiscountRulesDTO> listByValidUntilToday() {
        Date today = new Date();
        return discountRulesService.findByValidUntilAfter(today);
    }

    @GetMapping(value = "/product/{uuid}")
    public List<DiscountRulesDTO> listByProductUuid(@PathVariable("uuid") final String uuid) throws EntityNotFoundException{
        return discountRulesService.findByProduct(uuid);
    }
}
