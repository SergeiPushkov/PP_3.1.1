package app.Dao;

import app.Model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void createUsers(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> readUsers() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }

    @Override
    public User getUsers(Long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteUsers(Long id) {
        TypedQuery<User> query = entityManager.createQuery("delete from User u where u.id = :id",User.class);
        query.setParameter("id",id);

    }
}
