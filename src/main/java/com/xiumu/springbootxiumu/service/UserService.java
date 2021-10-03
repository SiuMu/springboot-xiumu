package com.xiumu.springbootxiumu.service;

import com.xiumu.springbootxiumu.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserManager userManager;
}
