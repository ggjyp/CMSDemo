package com.jyp.CMSDemo.pojo;

/**
 * Author   : jyp
 * Date     : 2017/3/16 14:53
 * Describe :
 */
public class Site {
    private String token;
    private String name;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Site() {

    }

    public Site(String token, String name) {
        this.token = token;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Site{" +
                "token='" + token + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
