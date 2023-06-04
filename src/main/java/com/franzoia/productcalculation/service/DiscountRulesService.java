package com.franzoia.productcalculation.service;

import com.franzoia.productcalculation.domain.*;
import com.franzoia.productcalculation.exception.ConstraintsViolationException;
import com.franzoia.productcalculation.exception.EntityNotFoundException;
import com.franzoia.productcalculation.repository.DiscountRulesRepository;
import com.franzoia.productcalculation.util.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DiscountRulesService extends DefaultService<DiscountRules, Long> {

    @Autowired
    ProductsService productsService;

    public DiscountRulesService(final DiscountRulesRepository repository) {
        super(repository);
    }

    @Transactional
    public DiscountRulesDTO create(DiscountRulesDTO dto) throws ConstraintsViolationException {
        DiscountRules discountRules = DiscountRulesMapper.makeDiscountRules(dto);
        return DiscountRulesMapper.makeDTO(create(discountRules));
    }

    /**
     * Update a products information.
     *
     * @param id DIscoountRule ID
     * @throws EntityNotFoundException
     */
    @Transactional
    public void update(final Long id, final DiscountRulesDTO dto) throws EntityNotFoundException {
        DiscountRules discountRules = findByIdChecked(id);
        discountRules.setMinQuantity(dto.getMinQuantity());
        discountRules.setAmount(dto.getAmount());
        discountRules.setValidUntil(dto.getValidUntil());
    }

    public List<DiscountRulesDTO> findByProduct(final Long productUuid) throws EntityNotFoundException {
        Products products = productsService.find(productUuid);
        return DiscountRulesMapper.makeListDTO(((DiscountRulesRepository) repository).findByProduct(products));
    }

    public List<DiscountRulesDTO> findByValidUntilAfter(final Date validUntil) {
        return DiscountRulesMapper.makeListDTO(((DiscountRulesRepository) repository).findByValidUntilAfter(validUntil));
    }
}
