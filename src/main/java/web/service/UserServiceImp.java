package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.Dao.UserDao;
import web.Model.User;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;
@Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public void addUser(User user) {
    userDao.addUser(user);
    }
    @Transactional
    @Override
    public User updateUser(User user) {
    return userDao.updateUser(user);
    }

    @Override
    public User findById(Long id) {
    return userDao.findById(id);
    }
    @Transactional
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    @Override
    public void deleteUser(Long id) {
        User user = userDao.findById(id);
        if (user == null){
            throw new UserNotFindExeption("User with id " + id + " not found");
        }
        userDao.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
//    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.POST)
//    public ResponseEntity<User> getDeleteUser(){
//    return new ResponseEntity<>(HttpStatus.OK);
//    }

    static class UserNotFindExeption extends RuntimeException {
        public UserNotFindExeption(String message) {
            super(message);
        }
    }
}
