package com.franzoia.productcalculation.service;

import com.franzoia.productcalculation.domain.Products;
import com.franzoia.productcalculation.domain.ProductsDTO;
import com.franzoia.productcalculation.domain.ProductsMapper;
import com.franzoia.productcalculation.exception.ConstraintsViolationException;
import com.franzoia.productcalculation.exception.EntityNotFoundException;
import com.franzoia.productcalculation.repository.ProductRepository;
import com.franzoia.productcalculation.util.DefaultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ProductsService extends DefaultService<Products, Long> {

    public ProductsService(final ProductRepository productRepository) {
        super(productRepository);
    }

    /*
        create a new product
     */
    @Transactional
    public ProductsDTO create(ProductsDTO dto) throws ConstraintsViolationException {
        Products products = ProductsMapper.makeProduct(dto);
        return ProductsMapper.makeDTO(create(products));
    }

    /**
     * Update a products information.
     *
     * @param uuid PRoduct UUID
	 * @throws EntityNotFoundException
	 */
    @Transactional
    public void update(final Long uuid, final ProductsDTO dto) throws EntityNotFoundException {
        Products products = findByIdChecked(uuid);
        products.setName(dto.getName());
        products.setPrice(dto.getPrice());
    }

    /**
     * Find all products by name.
     *
     * @param name
     */
    public List<Products> findByName(final String name) {
        return ((ProductRepository) repository).findByNameLike(name + "%");
    }
}