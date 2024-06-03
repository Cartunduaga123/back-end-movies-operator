package com.unir.movie_app_operator.persistence.repository;

import com.unir.movie_app_operator.persistence.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;


public interface UserRepository extends ListCrudRepository<UserEntity, Integer> {
}
