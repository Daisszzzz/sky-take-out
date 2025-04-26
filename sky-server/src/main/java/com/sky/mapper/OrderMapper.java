package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName OrderMapper
 * @Author lenovo
 * @Date 2025/4/22 10:49
 **/
@Mapper
public interface OrderMapper {
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    void insert(Orders orders);

    @Select("select * from orders where id = #{orderId}")
    Orders getById(Long orderId);

    void update(Orders orders);

    Page<Orders> conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO);

    @Select("select count(id) from orders where status = #{orderStatus}")
    Integer countStatus(Integer orderStatus);
}
