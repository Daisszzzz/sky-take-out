package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author lenovo
 * @Date 2025/4/12 19:47
 **/

@Mapper
public interface SetmealDishMapper {

    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);


    void insertBatch(List<SetmealDish> setmealDishes);

    void deleteDishInSetmealByIds(List<Long> ids);


    void deleteDishInSetmealById(Long setmealId);

    List<SetmealDish> getDishesBySetmealId(Long setmealId);
}
