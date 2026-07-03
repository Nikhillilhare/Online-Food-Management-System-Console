package model;

public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String mobile;
    private String Password;

    public Customer(int customerId, String name, String email, String mobile, String password) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        Password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "Customer = " +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'';
    }
}
