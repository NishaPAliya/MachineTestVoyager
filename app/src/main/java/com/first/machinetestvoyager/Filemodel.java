package com.first.machinetestvoyager;

public class Filemodel {
    String title,vurl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    public Filemodel(String title, String vurl) {
        this.title = title;
        this.vurl = vurl;


    }
}
