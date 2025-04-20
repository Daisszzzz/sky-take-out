package com.sky.service;

import com.sky.dto.ShoppingCartDTO;

/**
 * @Author lenovo
 * @Date 2025/4/20 11:10
 **/
public interface ShoppingCartService {

    /**
     * 添加购物车
     * @param shoppingCartDTO
     */
    public void addShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
