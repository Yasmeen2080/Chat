package com.example.yasmeen.chatapp.firebase.Models;

/**
 * Created by Yasmeen on 3/11/2019.
 */

public class Model_ChatRoom {
    String id;
    String name;
    String desc;
String createat;

    public String getCreateat() {
        return createat;
    }

    public void setCreateat(String createat) {
        this.createat = createat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Model_ChatRoom() {
    }

    public Model_ChatRoom(String name, String desc, String createAt) {
        this.name = name;
this.createat=createAt;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
