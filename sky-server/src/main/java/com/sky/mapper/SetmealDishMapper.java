package com.sky.mapper;

import com.sky.entity.SetmealDish;
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
}
