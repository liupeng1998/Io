package com.liupeng.entiey;

/*
用户信息表
 */
public class user {
    private  int userID;        //编号
    private  String userName;   //用户名
    private  String password;   //密码
    private  String status;     //身份(注册用户R，管理员M)

    public user() {
    }


    public user(int userID, String userName, String password, String status) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "user{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
