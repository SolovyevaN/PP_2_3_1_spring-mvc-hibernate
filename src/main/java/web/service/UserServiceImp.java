package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import web.Dao.UserDao;
import web.Model.User;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Primary
@Transactional
public class UserServiceImp implements UserService {
    private final UserDao userDao;
@Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
    userDao.addUser(user);
    }

    @Override
    public User updateUser(User user) {
    return userDao.updateUser(user);
    }

    @Override
    public User findById(Long id) {
    return userDao.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userDao.findById(id);
        if (user == null){
            throw new NoSuchElementException("User with id " + id + " not found");
        }
        userDao.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
