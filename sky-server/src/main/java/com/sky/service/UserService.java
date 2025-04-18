package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * @Author lenovo
 * @Date 2025/4/18 15:32
 **/
public interface UserService {

    /**
     * 微信登陆
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
