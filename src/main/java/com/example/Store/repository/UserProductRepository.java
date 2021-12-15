package com.example.Store.repository;

import com.example.Store.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProductRepository extends JpaRepository<UserProduct, Long> {
    List<UserProduct> findUserProductsByOrderId(Long id);
}
