package com.unir.movie_app_operator.persistence.repository;

import com.unir.movie_app_operator.persistence.entity.DetalleOrdenEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface DetalleOrdenRepository extends ListCrudRepository<DetalleOrdenEntity, Integer> {
}
