package com.unir.movie_app_operator.persistence.repository;

import com.unir.movie_app_operator.persistence.entity.OrdenesEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrdenesRepository extends ListCrudRepository<OrdenesEntity, Integer> {
}
