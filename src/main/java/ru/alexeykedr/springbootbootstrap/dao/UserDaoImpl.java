package ru.alexeykedr.springbootbootstrap.dao;

import org.springframework.security.core.userdetails.UserDetails;
import ru.alexeykedr.springbootbootstrap.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        User someUser = entityManager.find(User.class, id);
        entityManager.remove(someUser);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserByUsername(String username) {
        return entityManager.createQuery("select u from User u where u.name =: username", User.class)
                .setParameter("username", username).getSingleResult();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}
