package ModelPackage;

public class Admin {
    private String name;
    private Integer password;

    public Admin(Integer id, String name, String password) {
        setName(name);
        setPassword(password);
    }

    //region setter
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password.hashCode();
    }
    //endregion

    //region getter

    public String getName() {
        return name;
    }
    public Integer getPassword() {
        return password;
    }
    //endregion

}