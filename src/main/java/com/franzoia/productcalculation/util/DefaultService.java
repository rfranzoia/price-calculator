package com.franzoia.productcalculation.util;

import com.franzoia.productcalculation.exception.ConstraintsViolationException;
import com.franzoia.productcalculation.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.CrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


public abstract class DefaultService<T extends DefaultEntity, ID> implements Service<T, ID> {

    protected static final Logger LOG = LoggerFactory.getLogger(DefaultService.class);

    protected final CrudRepository<T, ID> repository;

    public DefaultService(final CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T find(final ID id) throws EntityNotFoundException {
        return findByIdChecked(id);
    }

    @Override
    public T create(T t) throws ConstraintsViolationException {
        try {
            T savedT = repository.save(t);
            return savedT;
        } catch (DataIntegrityViolationException e) {
            LOG.error("ConstraintsViolationException while creating an Entity: {}", t.toString(), e);
            throw new ConstraintsViolationException(e);
        }

    }

    @Override
    @Transactional
    public void delete(final ID id) throws EntityNotFoundException {
        T t = findByIdChecked(id);
        repository.delete(t);
    }

    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        repository.findAll()
                .forEach(t -> {
                    list.add(t);
                });
        return list;
    }

    protected List<T> findAny() {
        List<T> list = new ArrayList<>();
        repository.findAll()
                .forEach(t -> {
                    list.add(t);
                });
        return list;
    }

    protected T findByIdChecked(final ID id) throws EntityNotFoundException {
        T t = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + id));
        return t;
    }
}
