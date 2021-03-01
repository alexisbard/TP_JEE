package junia.lab04.core.dao;

import junia.lab04.core.entity.Product;
import junia.lab04.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u ")
    List<User> findAllUsers();
}

