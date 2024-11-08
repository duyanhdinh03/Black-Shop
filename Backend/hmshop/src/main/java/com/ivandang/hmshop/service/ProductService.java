package com.ivandang.hmshop.service;

import com.ivandang.hmshop.dto.ProductDTO;
import com.ivandang.hmshop.dto.ProductImageDTO;
import com.ivandang.hmshop.model.Product;
import com.ivandang.hmshop.model.ProductImage;
import com.ivandang.hmshop.responses.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDTO productDTO) throws Exception;
    Product getProductById(long id) throws Exception;
    public Page<ProductResponse> getAllProducts(String keyword,
                                                Long categoryId, PageRequest pageRequest);
    Product updateProduct(long id, ProductDTO productDTO) throws Exception;
    void deleteProduct(long id);
    boolean existsByName(String name);
    ProductImage createProductImage(
            Long productId,
            ProductImageDTO productImageDTO) throws Exception;
    List<Product> findProductsByIds(List<Long> productIds);
}
