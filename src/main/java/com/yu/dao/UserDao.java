package com.yu.dao;

import com.yu.domain.User;

public interface UserDao {

    /** * @param userId * @return User */
    public User selectUserById(Integer userId);  

}