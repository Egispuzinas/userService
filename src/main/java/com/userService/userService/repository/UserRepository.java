package com.userService.userService.repository;

import com.userService.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Long> {

    User findById(long id);
    List<User> findAll();
    User save(User usertoSave);
    User deleteById(long id);


}
//Optional arba yra useris arba nera.