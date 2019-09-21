package com.example.yasmeen.chatapp.firebase.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yasmeen.chatapp.firebase.Models.Model_ChatRoom;
import com.example.yasmeen.chatapp.R;
import com.example.yasmeen.chatapp.firebase.Daos.ChatsRoomDao;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomActivity extends AppCompatActivity {
EditText ed_name,ed_desc;
Button btn_addroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        ed_name=findViewById(R.id.room_name);

        ed_desc=findViewById(R.id.desc);
        btn_addroom=findViewById(R.id.add_btn);
btn_addroom.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String nameString=ed_name.getText().toString();
        String descString=ed_desc.getText().toString();
        SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String currentTime=date.format(new Date());
        Model_ChatRoom chatRoom=new Model_ChatRoom(nameString,descString,currentTime);
    ChatsRoomDao.AddRoom(chatRoom, new OnSuccessListener() {
        @Override
        public void onSuccess(Object o) {
finish();
//startActivity(new Intent(RoomActivity.this,HomeActivity.class));
            Toast.makeText(RoomActivity.this,"Room Added",Toast.LENGTH_LONG).show();
        }
    }, new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            Toast.makeText(RoomActivity.this,"Error",Toast.LENGTH_LONG).show();
        }
    });

    }
});
    }
}
