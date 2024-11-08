package com.ivandang.hmshop.service;

import com.ivandang.hmshop.dto.OrderDetailsDTO;
import com.ivandang.hmshop.exceptions.DataNotFoundException;
import com.ivandang.hmshop.model.OrderDetails;

import java.util.List;

public interface OrderDetailsService {
    OrderDetails createOrderDetail(OrderDetailsDTO newOrderDetail) throws Exception;
    OrderDetails getOrderDetail(Long id) throws DataNotFoundException;
    OrderDetails updateOrderDetail(Long id, OrderDetailsDTO newOrderDetailData)
            throws DataNotFoundException;
    void deleteById(Long id);
    List<OrderDetails> findByOrderId(Long orderId);


}
