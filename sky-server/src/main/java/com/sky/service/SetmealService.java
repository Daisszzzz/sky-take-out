package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;

/**
 * @Author lenovo
 * @Date 2025/4/15 9:01
 **/


public interface SetmealService {

    /**
     * 分页查询相关接口
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 增加套餐
     * @param setmealDTO
     */
    void addSetmeal(SetmealDTO setmealDTO);


    /**
     * 删除套餐(批量)
     * @param ids
     */
    void deleteSetmeal(List<Long> ids);

}
