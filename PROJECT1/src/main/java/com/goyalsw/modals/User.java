package main.java.com.goyalsw.modals;

public class User {
    private String userId;
    private String name;
    private String emailId;
    private String phoneNumber;

    public User(String userId, String name, String emailId, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    /*
        Setters
    */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*
    *   Getters
    * */

    public String getId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
