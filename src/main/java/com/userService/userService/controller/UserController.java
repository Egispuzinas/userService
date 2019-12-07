package com.userService.userService.controller;

import com.userService.userService.entities.User;
import com.userService.userService.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/hello")
    public static String gethello() {
        return "Hello World";
    }

    @GetMapping("/search/{id}")
    public User search(@PathVariable long id) {
        return repository.findById(id);
    }

    @PostMapping(path = "/insertuser/", consumes = "application/json", produces = "application/json")
    public void saveUser(@RequestBody User user) {
            repository.save(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public NotFoundException deleteUser(long id){
        repository.deleteById(id);
        try {
            repository.deleteById(id);
        }catch (Exception e) {
            return new NotFoundException("User not found with id" +id);
        }
        return null;
    }

    @PutMapping(path = "/setOtpPassword/{id}", consumes = "application/json", produces = "application/json")
    public User setOtpPassword(@PathVariable Long id, @Valid @RequestBody User user) throws NotFoundException {
        OtpGenerator otp = new OtpGenerator();
        return repository.findById(id)
                .map(user1 -> {
                    user1.setOtp(otp.getOtp());
                    return repository.save(user1);
                }).orElseThrow (() -> new NotFoundException("User not found with id" + id));

    }

    @GetMapping("/generateOtp")
    public String generateOtp(){
        OtpGenerator otp = new OtpGenerator();
        return otp.getOtp();
    };
}
