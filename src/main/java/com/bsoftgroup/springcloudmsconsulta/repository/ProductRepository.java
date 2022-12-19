package com.bsoftgroup.springcloudmsconsulta.repository;

import com.bsoftgroup.springcloudmsconsulta.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
