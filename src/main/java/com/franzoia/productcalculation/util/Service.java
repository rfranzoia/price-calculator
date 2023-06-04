package com.franzoia.productcalculation.util;

import com.franzoia.productcalculation.exception.ConstraintsViolationException;
import com.franzoia.productcalculation.exception.EntityNotFoundException;

import java.util.List;

public interface Service<T extends DefaultEntity, ID> {

    T find(ID id) throws EntityNotFoundException;

    T create(T t) throws ConstraintsViolationException;

    void delete(ID id) throws EntityNotFoundException;

    List<T> findAll();

}