package com.unir.movie_app_operator.service;

import com.unir.movie_app_operator.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.unir.movie_app_operator.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAll() {
        return this.userRepository.findAll();
    }

    public UserEntity get(int idUser) {
        return this.userRepository.findById(idUser).orElse(null);
    }

}
