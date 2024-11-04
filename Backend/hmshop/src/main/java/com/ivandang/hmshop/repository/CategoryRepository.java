package com.ivandang.hmshop.repository;


import com.ivandang.hmshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
