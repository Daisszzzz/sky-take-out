package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.SetmealService;
import com.sky.vo.DishVO;
import com.sky.vo.SetmealVO;
import nonapi.io.github.classgraph.fileslice.ArraySlice;
import org.apache.http.cookie.SM;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SetmealServiceImpl
 * @Author lenovo
 * @Date 2025/4/15 9:02
 **/
@Service
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealMapper setmealMapper;

    @Autowired
    private SetmealDishMapper setmealDishMapper;


    @Override
    public PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO) {
        PageHelper.startPage(setmealPageQueryDTO.getPage(), setmealPageQueryDTO.getPageSize());
        Page<SetmealVO> page = setmealMapper.pageQuery(setmealPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void addSetmeal(SetmealDTO setmealDTO) {
        Setmeal setmeal = new Setmeal();
        BeanUtils.copyProperties(setmealDTO,setmeal);

        List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();

        // 先将套餐加入数据库中，数据库回显ID值
        setmealMapper.insert(setmeal);

        // 由mapper回显自增的ID键值
        Long setmealId = setmeal.getId();

        if(setmealDishes != null && setmealDishes.size() > 0) {
            setmealDishes.forEach(setmealDish -> {
                // 将套餐ID赋值给对应套餐中的菜品
                setmealDish.setSetmealId(setmealId);
            });
            setmealDishMapper.insertBatch(setmealDishes);
        }
    }

    @Override
    public void deleteSetmeal(List<Long> ids) {

        // 删除套餐中的菜品
        setmealDishMapper.deleteDishInSetmealByIds(ids);

        // 删除套餐
        setmealMapper.deleteSetmealByIds(ids);

    }

    @Override
    public void updateSetmeal(SetmealDTO setmealDTO) {

        // 修改套餐中的信息
        Setmeal setmeal = new Setmeal();
        BeanUtils.copyProperties(setmealDTO,setmeal);
        Long setmealId = setmeal.getId();
        setmealDishMapper.update(setmeal);

        // 修改套餐中的菜品
        // 删除原有套餐中的菜品
        setmealDishMapper.deleteDishInSetmealById(setmealId);

        List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();

        // 重新向菜单中插入新菜品（不论和之前是否有区别）
        if(setmealDishes != null && setmealDishes.size() > 0) {
            setmealDishes.forEach(setmealDish -> {
                // 将套餐ID赋值给对应套餐中的菜品
                setmealDish.setSetmealId(setmealId);
            });
            setmealDishMapper.insertBatch(setmealDishes);
        }
    }

    @Override
    public SetmealVO getById(String id) {
        SetmealVO setmealVO = setmealMapper.getById(id);

        List<SetmealDish> dishesInSetmeal = setmealDishMapper.getDishesBySetmealId(id);

        setmealVO.setSetmealDishes(dishesInSetmeal);
        return setmealVO;
    }


}
