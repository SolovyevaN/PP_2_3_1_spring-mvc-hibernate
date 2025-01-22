package web.Dao;

import org.springframework.stereotype.Repository;
import web.Model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> deleteUser(Long id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
        return getAllUsers();
    }

    @Override
    public List<User> getAllUsers() {
       return entityManager.createQuery("from User", User.class).getResultList();
    }
}
