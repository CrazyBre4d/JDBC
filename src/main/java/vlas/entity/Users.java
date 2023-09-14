package vlas.entity;

import java.util.Objects;

public class Users {
    private Long userId;
    private String firstName;
    private String lastName;
    private Long roleId;
    private String login;
    private String password;

    public Users(){}
    public Users( String firstName, String lastName, Long roleId, String login, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.roleId = roleId;
        this.login = login;
        this.password = password;
    }

    public Users(Long userId, String firstName, String lastName, Long roleId, String login, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleId = roleId;
        this.login = login;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    @Override
    public String toString() {
        return "Users:   | User_id  |   F_Name   |    L_Name   |    Role_Id |  Login    |      Password\n" +
                "             " +"  " + userId+"           " +firstName+ "        "+ lastName + "        " + roleId+"         "+login+"         "+password +"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userId, users.userId) && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName) && Objects.equals(roleId, users.roleId) && Objects.equals(login, users.login) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, roleId, login, password);
    }
}



