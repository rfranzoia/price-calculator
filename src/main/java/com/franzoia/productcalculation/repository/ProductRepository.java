package com.franzoia.productcalculation.repository;

import com.franzoia.productcalculation.domain.Products;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Products, String> {

    List<Products> findByNameLike(String name);

}