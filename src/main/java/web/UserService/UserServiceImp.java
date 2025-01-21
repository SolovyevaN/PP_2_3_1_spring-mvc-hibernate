package web.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.UserDao;
import web.Dao.UserDaoImp;
import web.Model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {


    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void findById(Long id) {

    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
