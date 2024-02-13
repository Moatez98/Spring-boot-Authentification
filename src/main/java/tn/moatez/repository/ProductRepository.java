package tn.moatez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.moatez.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
