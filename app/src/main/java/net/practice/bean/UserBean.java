package net.practice.bean;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class UserBean extends DataSupport {

    @Column(unique = true, nullable = false)
    String UserName;
    @Column(nullable = false)
    String Password;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
