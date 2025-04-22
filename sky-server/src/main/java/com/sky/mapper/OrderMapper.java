package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName OrderMapper
 * @Author lenovo
 * @Date 2025/4/22 10:49
 **/
@Mapper
public interface OrderMapper {
    void insert(Orders orders);
}
