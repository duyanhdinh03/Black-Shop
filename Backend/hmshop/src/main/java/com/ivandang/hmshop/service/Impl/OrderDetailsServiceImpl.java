package com.ivandang.hmshop.service.Impl;

import com.ivandang.hmshop.dto.OrderDetailsDTO;
import com.ivandang.hmshop.exceptions.DataNotFoundException;
import com.ivandang.hmshop.model.Order;
import com.ivandang.hmshop.model.OrderDetails;
import com.ivandang.hmshop.model.Product;
import com.ivandang.hmshop.repository.OrderDetailsRepository;
import com.ivandang.hmshop.repository.OrderRepository;
import com.ivandang.hmshop.repository.ProductRepository;
import com.ivandang.hmshop.service.OrderDetailsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final ProductRepository productRepository;


    @Override
    public OrderDetails createOrderDetail(OrderDetailsDTO orderDetailsDTO) throws Exception {
        //tìm xem orderId có tồn tại ko
        Order order = orderRepository.findById(orderDetailsDTO.getOrderId())
                .orElseThrow(() -> new DataNotFoundException(
                        "Cannot find Order with id : "+orderDetailsDTO.getOrderId()));
        // Tìm Product theo id
        Product product = productRepository.findById(orderDetailsDTO.getProductId())
                .orElseThrow(() -> new DataNotFoundException(
                        "Cannot find product with id: " + orderDetailsDTO.getProductId()));
        OrderDetails orderDetail = OrderDetails.builder()
                .order(order)
                .product(product)
                .numberOfProducts(orderDetailsDTO.getNumberOfProducts())
                .price(Float.valueOf(orderDetailsDTO.getPrice()))
                .totalMoney((float) orderDetailsDTO.getTotalMoney())
                .color(orderDetailsDTO.getColor())
                .build();
        //lưu vào db
        return orderDetailsRepository.save(orderDetail);
    }

    @Override
    public OrderDetails getOrderDetail(Long id) throws DataNotFoundException {
        return orderDetailsRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException("Cannot find OrderDetail with id: "+id));
    }

    @Override
    @Transactional
    public OrderDetails updateOrderDetail(Long id, OrderDetailsDTO orderDetailsDTO)
            throws DataNotFoundException {
        //tìm xem order detail có tồn tại ko đã
        OrderDetails existingOrderDetail = orderDetailsRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Cannot find order detail with id: "+id));
        Order existingOrder = orderRepository.findById(orderDetailsDTO.getOrderId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find order with id: "+id));
        Product existingProduct = productRepository.findById(orderDetailsDTO.getProductId())
                .orElseThrow(() -> new DataNotFoundException(
                        "Cannot find product with id: " + orderDetailsDTO.getProductId()));
        existingOrderDetail.setPrice(Float.valueOf(orderDetailsDTO.getPrice()));
        existingOrderDetail.setNumberOfProducts(orderDetailsDTO.getNumberOfProducts());
        existingOrderDetail.setTotalMoney((float) orderDetailsDTO.getTotalMoney());
        existingOrderDetail.setColor(orderDetailsDTO.getColor());
        existingOrderDetail.setOrder(existingOrder);
        existingOrderDetail.setProduct(existingProduct);
        return orderDetailsRepository.save(existingOrderDetail);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        orderDetailsRepository.deleteById(id);
    }

    @Override
    public List<OrderDetails> findByOrderId(Long orderId) {
        return orderDetailsRepository.findByOrderId(orderId);
    }
}
