package Service;

import dao.UserDAOImpl;
import entity.User;

import java.sql.SQLException;

public class RegistrationService {
    private final UserDAOImpl userdaoimpl = new UserDAOImpl();

    public void createUser(User user) throws SQLException {
        userdaoimpl.createUser(user);
    }

}
