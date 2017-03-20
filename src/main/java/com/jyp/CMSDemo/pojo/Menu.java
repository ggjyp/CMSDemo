package com.jyp.CMSDemo.pojo;

/**
 * Author   : jyp
 * Date     : 2017/3/17 13:34
 * Describe : 目录实体类（考虑到数据库中的id在具体web项目中无实际意义，该实体类不加入id字段；同时本项目仅
 * 做练习使用，故不加入创建时间、删除时间、编辑时间等字段
 */
public class Menu {
    public String getMenuSign() {
        return menuSign;
    }

    public void setMenuSign(String menuSign) {
        this.menuSign = menuSign;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getLastDir() {
        return lastDir;
    }

    public void setLastDir(String lastDir) {
        this.lastDir = lastDir;
    }

    private String menuSign;
    private String menuName;
    private String dir;
    private String parent;
    private String lastDir;

    public Menu() {
    }

    public Menu(String menuSign, String menuName, String dir, String parent, String lastDir) {
        this.menuSign = menuSign;
        this.menuName = menuName;
        this.dir = dir;
        this.parent = parent;
        this.lastDir = lastDir;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuSign='" + menuSign + '\'' +
                ", menuName='" + menuName + '\'' +
                ", dir='" + dir + '\'' +
                ", parent='" + parent + '\'' +
                ", lastDir='" + lastDir + '\'' +
                '}';
    }
}
