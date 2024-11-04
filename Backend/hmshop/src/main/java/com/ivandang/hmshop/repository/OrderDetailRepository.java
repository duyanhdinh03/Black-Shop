package com.ivandang.hmshop.repository;

import com.ivandang.hmshop.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetails, Long> {
}
