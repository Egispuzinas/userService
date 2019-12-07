package com.userService.userService.repository;

import com.userService.userService.repository.entities.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Long> {

    User findById(long id);
    List<User> findAll();
    User save(User usertoSave);
    User deleteById(long id);


}
//Optional arba yra useris arba nera.