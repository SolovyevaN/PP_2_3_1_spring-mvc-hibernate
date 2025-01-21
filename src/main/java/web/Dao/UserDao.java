package web.Dao;

import web.Model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    User findById(Long id);
    List<User> deleteUser(Long id);
    List<User> getAllUsers();
}
