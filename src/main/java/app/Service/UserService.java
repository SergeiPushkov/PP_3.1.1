package app.Service;

import app.Model.User;

import java.util.List;

public interface UserService {
    void createUsers(User user);

    List<User> getAllUsers();

    User getUsers(Long id);

    void deleteUsers(Long id);

    void updateUser(User user);
}
