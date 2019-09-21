package com.example.yasmeen.chatapp.firebase.Models;

/**
 * Created by Yasmeen on 3/11/2019.
 */

public class Model_user {
    String username;
    String password;
    String id;
    String email;

    public String getUsername() {
        return username;
    }

    public Model_user() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
