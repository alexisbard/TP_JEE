package junia.lab04.core.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import junia.lab04.core.dao.UserDAO;
import junia.lab04.core.entity.User;

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
}

