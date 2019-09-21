package com.example.yasmeen.chatapp.firebase.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.yasmeen.chatapp.R;
import com.example.yasmeen.chatapp.firebase.Adapters.ChatThreadAdapter;
import com.example.yasmeen.chatapp.firebase.Daos.MessagesDao;
import com.example.yasmeen.chatapp.firebase.DataHolder;
import com.example.yasmeen.chatapp.firebase.Models.Message;
import com.example.yasmeen.chatapp.firebase.Models.Model_ChatRoom;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatConversation extends AppCompatActivity {
public static Model_ChatRoom chatroom;
RecyclerView recyclerview;
EditText edt_enterhere;
ImageButton img_send;
ChatThreadAdapter adapter;
LinearLayoutManager layoutmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_conversation);
recyclerview=findViewById(R.id.recyclerview__conversationchat);
edt_enterhere=findViewById(R.id.Edittext_typehere);
layoutmanager=new LinearLayoutManager(this);
layoutmanager.setStackFromEnd(true);
adapter=new ChatThreadAdapter(null);
recyclerview.setAdapter(adapter);
recyclerview.setLayoutManager(layoutmanager);
img_send=findViewById(R.id.imgbtn_send);
img_send.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String content=edt_enterhere.getText().toString();
        final Message message=new Message();
        message.setContent(content);
        message.setRoom_id(chatroom.getId());
        message.setSender_id(DataHolder.currentuser.getId());
message.setSendername(DataHolder.currentuser.getUsername());
        SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String currentTime=date.format(new Date());
message.setTime(currentTime);
        MessagesDao.AddMessage(message, new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
edt_enterhere.setText(null);
            }
        }, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ChatConversation.this,"Try Again Later",Toast.LENGTH_LONG).show();
            }
        });
    }
});
MessagesDao.getMessagebyRoomID(chatroom.getId()).addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
Message message=dataSnapshot.getValue(Message.class);
    adapter.AddData(message);
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});
    }
}
