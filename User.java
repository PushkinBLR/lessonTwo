package entity;

public class User {
    private int id;
    private String login;
    private String password;
    private String lastname;
    private String firstname;

    public User() {
    }

    public User(int id, String login, String password, String lastname, String firstname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public User(String login, String password, String lastname, String firstname) {
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
