package vlas.entity;

public class Roles {
    private  long role_id;
    private String role_name;

    public long getRoleId() {
        return role_id;
    }

    public void setRoleId(long role_id) {
        this.role_id = role_id;
    }

    public String getRoleName() {
        return role_name;
    }

    public void setRoleName(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
