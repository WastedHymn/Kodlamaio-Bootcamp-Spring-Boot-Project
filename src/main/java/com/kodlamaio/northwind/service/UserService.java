package com.kodlamaio.northwind.service;

import com.kodlamaio.northwind.core.entities.User;
import com.kodlamaio.northwind.core.repository.UserRepository;
import com.kodlamaio.northwind.core.utilities.results.DataResult;
import com.kodlamaio.northwind.core.utilities.results.Result;
import com.kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import com.kodlamaio.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result addUser(User user) {
        this.userRepository.save(user);
        return new SuccessResult("User saved: " + user.getEmail());
    }

    public DataResult<User> getByEmail(String email) {
        System.out.println("SEARCHING USER BY EMAIL...");
        return new SuccessDataResult<User>(this.userRepository.getByEmail(email), "User searched by email.");
    }
}
