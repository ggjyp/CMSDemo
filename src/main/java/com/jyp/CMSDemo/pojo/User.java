package com.jyp.CMSDemo.pojo;

/**
 * Created by jyp on 2017/3/7.
 */
public class User {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int id;
    private String username;
    private String password;
    private int status;    //账号状态(0管理员 1普通用户 2禁用)

    public User(){

    }

    public User(int id, String username, String password, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
