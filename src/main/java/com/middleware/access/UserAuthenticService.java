package com.middleware.access;

import com.middleware.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticService {

    @Autowired
    private AuthenticationService authenticationService;

    public boolean getUserPermission(String userName, String password) {
        return authenticationService.authenticate(userName, password);
    }
}
