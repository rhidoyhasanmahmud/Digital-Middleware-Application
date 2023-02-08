package com.middleware.service;

import com.middleware.model.User;
import com.middleware.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthenticationService {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String userName, String password) {

        User user = getValidActiveUserUsingUsername(userName);

        if (user == null) {
            return false;
        }

        boolean result = matchPassword(password, user.getPassword());

        if (result) {
            user.setTotalDataPullCount(user.getTotalDataPullCount() + 1);
            user.setLastDataPull(LocalDateTime.now());
            userRepository.save(user);
            log.info("User #{} has given correct passwords.", user.getUserName());
            return true;
        }else{
            log.info("User #{} has given wrong passwords.", user.getUserName());
        }
        return false;
    }

    private boolean matchPassword(String plainPassword, String hashPassword) {
        return BCrypt.checkpw(plainPassword, hashPassword);
    }

    private User getValidActiveUserUsingUsername(String username) {
        User user = userRepository.findByUserName(username);

        if (user == null) {
            log.info("User not found");
            return null;
        }

        if (user.accountLocked.equals(1)) {
            log.info("Your account has been locked");
            return null;
        }

        return user;
    }
}
