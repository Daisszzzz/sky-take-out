package com.sky.service;

import com.sky.dto.*;
import com.sky.result.PageResult;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

/**
 * @ClassName OrderServie
 * @Author lenovo
 * @Date 2025/4/22 10:45
 **/


public interface OrderService {


    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 查询历史订单
     * @param ordersPageQueryDTO
     * @return
     */
    PageResult pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    OrderVO displayOrderDetail(Long orderId);


    void cancelOrder(Long id);

    void reputation(Long id);

    /**
     * 条件查询订单
     * @param ordersPageQueryDTO
     * @return
     */
    PageResult conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO);

    OrderStatisticsVO orderStatistics();

    void confirmOrder(OrdersConfirmDTO ordersConfirmDTO);

    void rejectOrder(OrdersRejectionDTO ordersRejectionDTO);

    void adminCancelOrder(OrdersCancelDTO ordersCancelDTO);

    void deliveryOrders(Long id);

    void complete(Long id);

    /**
     * 客户催单
     * @param id
     */
    void reminder(Long id);
}
