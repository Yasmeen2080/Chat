package com.example.yasmeen.chatapp.firebase.Models;

/**
 * Created by Yasmeen on 3/11/2019.
 */

public class Message {
    String sender_id;
    String id;
    String room_id;
            String content;
String sendername;
String time;

    public Message() {
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Message(String sender_id, String id, String room_id, String content, String sendername, String time) {
        this.sender_id = sender_id;
        this.id = id;

        this.room_id = room_id;
        this.content = content;
        this.sendername = sendername;
        this.time = time;
    }
}
