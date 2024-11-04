package com.ivandang.hmshop.service;

import com.ivandang.hmshop.dto.ProductDTO;
import com.ivandang.hmshop.dto.ProductImageDTO;
import com.ivandang.hmshop.model.Product;
import com.ivandang.hmshop.model.ProductImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ProductService {
    Product createProduct(ProductDTO productDTO) throws Exception;
    Product getProductById(long id) throws Exception;
    Page<Product> getAllProducts(PageRequest pageRequest);
    Product updateProduct(long id, ProductDTO productDTO) throws Exception;
    void deleteProduct(long id);
    boolean existsByName(String name);
    ProductImage createProductImage(
            Long productId,
            ProductImageDTO productImageDTO) throws Exception;

}
