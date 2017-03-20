package com.jyp.CMSDemo.pojo;

/**
 * Author   : jyp
 * Date     : 2017/3/14 15:49
 * Describe :
 */
public class Page {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getHeadCode() {
        return headCode;
    }

    public void setHeadCode(String headCode) {
        this.headCode = headCode;
    }

    public String getBodyCode() {
        return bodyCode;
    }

    public void setBodyCode(String bodyCode) {
        this.bodyCode = bodyCode;
    }

    private int id;
    private String versionId;
    private String versionName;
    private String headCode;
    private String bodyCode;

    public Page(){

    }

    public Page(String versionId, String versionName) {
        this.versionId = versionId;
        this.versionName = versionName;
    }

    public Page(int id, String versionId, String versionName, String headCode, String bodyCode) {
        this.id = id;
        this.versionId = versionId;
        this.versionName = versionName;
        this.headCode = headCode;
        this.bodyCode = bodyCode;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", versionId='" + versionId + '\'' +
                ", versionName='" + versionName + '\'' +
                ", headCode='" + headCode + '\'' +
                ", bodyCode='" + bodyCode + '\'' +
                '}';
    }
}
