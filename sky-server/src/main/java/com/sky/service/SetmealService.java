package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

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

    /**
     * 修改套餐
     * @param setmealDTO
     */
    void updateSetmeal(SetmealDTO setmealDTO);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    SetmealVO getById(Long id);

    /**
     * 根据套餐ID修改套餐状态
     * @param status
     * @param id
     */
    void setSellingStatus(Integer status, Long id);
}
