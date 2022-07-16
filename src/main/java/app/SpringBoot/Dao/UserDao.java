package app.SpringBoot.Dao;

import app.SpringBoot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {
}
