package model;

public class ModelAdminRegister {
    private String adminRName;
    private String adminRSurname;
    private String adminRPassword;

    public ModelAdminRegister() {
    }

    public ModelAdminRegister(String adminRName, String adminRSurname, String adminRPassword) {
        this.adminRName = adminRName;
        this.adminRSurname = adminRSurname;
        this.adminRPassword = adminRPassword;
    }
    
    public String getAdminRName() {
        return adminRName;
    }

    public void setAdminRName(String adminRName) {
        this.adminRName = adminRName;
    }

    public String getAdminRSurname() {
        return adminRSurname;
    }

    public void setAdminRSurname(String adminRSurname) {
        this.adminRSurname = adminRSurname;
    }

    public String getAdminRPassword() {
        return adminRPassword;
    }

    public void setAdminRPassword(String adminRPassword) {
        this.adminRPassword = adminRPassword;
    }
    
}
