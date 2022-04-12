package dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    void createUser(User user);

    List<User> findAllUser() throws SQLException;

    int delete(User user);

    int update(User user);


}
