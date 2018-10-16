package net.practice.mvp.model;


import net.practice.bean.LoginBean;

public class LoginModel extends BaseModel {
    private LoginBean memberInfo;

    public LoginBean getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(LoginBean memberInfo) {
        this.memberInfo = memberInfo;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "memberInfo=" + memberInfo +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
