package junia.lab04.core.dao;

import junia.lab04.core.entity.Product;
import junia.lab04.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
<<<<<<< HEAD
    @Query("SELECT DISTINCT u FROM User u ")
=======
    @Query("SELECT DISTINCT p FROM Product p ")
>>>>>>> b9e6aac012531352e00dc7bcb2712209e712ec85
    List<User> findAllUsers();
}

