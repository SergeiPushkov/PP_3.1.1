package app.Service;

import app.Model.User;

import java.util.List;

public interface UserService {
    void createUsers(User user);

    List<User> readUsers();

    User getUsers(Long id);

    void deleteUsers(Long id);
}
