package junia.lab04.core.service;

import junia.lab04.core.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import junia.lab04.core.dao.UserDAO;
import junia.lab04.core.entity.User;

import java.util.List;

@Service
@Transactional
public class UserService {

    private UserDAO userDAO;


    public UserService(final UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public void deleteAll() {
        userDAO.deleteAll();
    }


    public void save(User user) {
        userDAO.save(user);
    }


    public long countAll() {
        return userDAO.count();
    }


    public List<User> findAllUsers(){
        return userDAO.findAllUsers();
    }


    public void deleteById(final long id) {
        userDAO.deleteById(id);
    }
}

