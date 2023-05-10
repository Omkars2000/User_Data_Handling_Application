package org.jspider.Vertical_ask.module;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class User {
    public User(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_phone")
    private String userPhone;

    public User(int userId, String uerName, String userEmail, String userPhone) {
        this.userId = userId;
        this.userName = uerName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String uerName) {
        this.userName = uerName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone ;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
