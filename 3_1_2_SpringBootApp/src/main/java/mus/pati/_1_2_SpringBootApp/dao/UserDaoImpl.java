package mus.pati._1_2_SpringBootApp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mus.pati._1_2_SpringBootApp.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(showUserById(id).orElseThrow(() -> new RuntimeException("User by id = " + id + " not found")));
        ;
    }

    @Override
    public void updateUser(User user) {

        entityManager.merge(user);
    }

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public Optional<User> showUserById(long id) {

        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public void updateUserInfo(int id, User user) {
        User updatedUser = entityManager.find(User.class, id);
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
    }
}
