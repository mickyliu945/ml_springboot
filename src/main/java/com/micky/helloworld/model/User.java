package com.micky.helloworld.model;

/**
 * Created by Administrator on 2017/4/21.
 */
public class User {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String password;
    private int sex;
    private String nickName;

    public User() {
        super();
    }

    public User(String userName, String passWord, int sex) {
        super();
        this.password = passWord;
        this.name = userName;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "name " + this.name + ", pasword " + this.password + "sex " + sex;
    }
}
