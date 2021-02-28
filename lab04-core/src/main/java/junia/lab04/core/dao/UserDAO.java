package junia.lab04.core.dao;

import junia.lab04.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    @Query("SELECT DISTINCT p FROM Product p ")
    List<User> findAllUsers();
}

