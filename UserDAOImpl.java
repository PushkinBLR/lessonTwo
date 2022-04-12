package dao;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.postgresql.util.JdbcBlackHole.close;

public class UserDAOImpl implements UserDAO {

    public static final String query1 = "INSERT  INTO users (login,password,lastname, firstname) VALUES (?,?,?,?)";
    public static final String query2 = "SELECT * FROM users JOIN login_fullname ON users.id_login = fullname.id_fullname" +
            "JOIN fullname ON login_fullname.id_fullname = fullname.id_fullname WHERE users.id_login =?";
    public static final String query3 = "DELETE FROM users WHERE id=?";
    public static final String query4 = "UPDATE users SET login=?,password=?,lastname=?,firstname=? WHERE id=?";

    public void createUser(User user)  {
        List<User> userList = null;
        try (Connection con = DataSourceFactory.getConnection()){
             con.setAutoCommit(false);
             con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
             PreparedStatement pst = con.prepareStatement(query1);
             ResultSet rs = pst.executeQuery(); {
            userList = new ArrayList<>();
            User use = new User();
            use.setLogin(rs.getString("login"));
            use.setPassword(rs.getString("password"));
            use.setLastname(rs.getString("lastname"));
            use.setFirstname(rs.getString("firstname"));
            userList.add(use);
                con.commit();}
        } catch (SQLException exception) {
            exception.printStackTrace();
        }


    }



    @Override
    public  List<User> findAllUser() throws SQLException {
        Connection con = DataSourceFactory.getConnection();
        con.setAutoCommit(false);
        con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query2);
            ResultSet res = ps.executeQuery();
            List<User> users = new ArrayList<>();
            while (res.next()) {
                User user = new User();
                user.setId(res.getInt("id"));
                user.setLogin(res.getString("login"));
                user.setPassword(res.getString("password"));
                user.setLastname(res.getString("lastname"));
                user.setFirstname(res.getString("firstname"));
                users.add(user);
                con.commit();}
            return users;
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            close(ps);
        }
        return null;
    }

    public int delete(User user) {
        int status = 0;
        try {
            Connection con = DataSourceFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(query3);
            ps.setInt(1, user.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    public int update(User user) {
        int status = 0;
        try {
            Connection con = DataSourceFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(query4);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getLastname());
            ps.setString(5, user.getFirstname());
            status = ps.executeUpdate();
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }



}
