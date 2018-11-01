package net.practice.mvp.model;


import net.practice.bean.UserBean;

public class LoginModel extends BaseModel {
    private UserBean memberInfo;

    public UserBean getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(UserBean memberInfo) {
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
