package com.userService.userService.repository;

import com.userService.userService.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
    List<User> findAll();
    User save(User user);
}
//Optional arba yra useris arba nera.