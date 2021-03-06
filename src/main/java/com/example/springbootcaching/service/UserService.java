package com.example.springbootcaching.service;

import com.example.springbootcaching.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames = {"users"})
public class UserService {
    private List<User> users = new ArrayList<>();

    @Autowired
    UserService() {
    }

    @PostConstruct
    private void fillUsers() {
        users.add(User.builder().username("user_1").age(20).build());
        users.add(User.builder().username("user_2").age(76).build());
        users.add(User.builder().username("user_3").age(54).build());
        users.add(User.builder().username("user_4").age(30).build());
    }

    public List<User> findall() {
        simulateSlowService();
        return this.users;
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public User updateUser(User user) {
        this.users.set(0, user);
        return this.users.get(0);
    }
}
