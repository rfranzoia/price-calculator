package com.franzoia.productcalculation.controller;

import com.franzoia.productcalculation.domain.ProductsDTO;
import com.franzoia.productcalculation.domain.ProductsMapper;
import com.franzoia.productcalculation.exception.ConstraintsViolationException;
import com.franzoia.productcalculation.exception.EntityNotFoundException;
import com.franzoia.productcalculation.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * All operations with a product will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(final ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(value = "/{uuid}")
    public ProductsDTO getProduct(@PathVariable("uuid") final Long uuid) throws EntityNotFoundException {
        return ProductsMapper.makeDTO(productsService.find(uuid));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductsDTO createProduct(@Validated @RequestBody final ProductsDTO productsDTO) throws ConstraintsViolationException {
        return productsService.create(productsDTO);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("uuid") final Long uuid) throws EntityNotFoundException {
        productsService.delete(uuid);
    }

    @PutMapping("/{uuid}")
    public void update(@PathVariable final Long uuid, @RequestBody final ProductsDTO productsDTO)
            throws EntityNotFoundException {
        productsService.update(uuid, productsDTO);
    }

    @GetMapping("/name/{name}")
    public List<ProductsDTO> findProductsByName(@PathVariable final String name) {
        return ProductsMapper.makeListDTO(productsService.findByName(name));
    }

    @GetMapping
    public List<ProductsDTO> findAllProducts() {
        return ProductsMapper.makeListDTO(productsService.findAll());
    }
}