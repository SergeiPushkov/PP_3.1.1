package app.SpringBoot.Service;


import app.SpringBoot.Dao.UserDao;
import app.SpringBoot.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserServiceImp {
    private final UserDao userDao;
    @Autowired
    public UserServiceImp( UserDao userDao) {
        this.userDao = userDao;
    }
    public User findById(Long id) {
        return userDao.getReferenceById(id);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void deleteById(long id) {
        userDao.deleteById(id);
    }
}
