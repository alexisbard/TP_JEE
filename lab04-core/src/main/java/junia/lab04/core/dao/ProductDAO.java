package junia.lab04.core.dao;

import junia.lab04.core.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT p FROM Product p ")
    List<Product> findAllProducts();
}
