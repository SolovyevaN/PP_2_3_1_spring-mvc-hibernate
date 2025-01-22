package web.service;

import web.Model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void findById(Long id);
    void deleteUser(Long id);
    List<User> getAllUsers();

}
