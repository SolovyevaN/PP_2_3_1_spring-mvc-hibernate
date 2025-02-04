package web.Dao;

import web.Model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    User updateUser(User user);

    User findById(Long id);

    void deleteUser(Long id);

    List<User> getAllUsers();
}
