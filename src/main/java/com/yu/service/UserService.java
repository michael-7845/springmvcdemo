package com.yu.service;

import com.yu.domain.User;

public interface UserService {
    User selectUserById(Integer userId); 
}