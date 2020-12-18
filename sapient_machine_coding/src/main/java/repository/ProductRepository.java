package repository;

import org.springframework.stereotype.Repository;

import model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
