package model;

public class ModelPersonel {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phoneNumber;
    private String adress;
    private String departmant;

    public ModelPersonel() {
    }

    public ModelPersonel(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    
    public ModelPersonel(String name, String surname, int age, String email, String phoneNumber, String adress, String departmant) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.departmant = departmant;
    }
    
    public ModelPersonel(int id, String name, String surname, int age, String email, String phoneNumber, String adress, String departmant) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.departmant = departmant;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDepartmant() {
        return departmant;
    }

    public void setDepartmant(String departmant) {
        this.departmant = departmant;
    }
    
}
