package com.example.yasmeen.chatapp.firebase.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.yasmeen.chatapp.R;
import com.example.yasmeen.chatapp.firebase.Adapters.RoomsAdapter;
import com.example.yasmeen.chatapp.firebase.Models.Model_ChatRoom;
import com.example.yasmeen.chatapp.firebase.MyDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
Button add_new_room;
RecyclerView recyclerview;
RecyclerView.LayoutManager layoutManager;
RoomsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        add_new_room=findViewById(R.id.add_new_room);
        recyclerview=findViewById(R.id.recycler_view);
        adapter=new RoomsAdapter(null);
        layoutManager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListner(new RoomsAdapter.OnItemClickListner() {
            @Override
            public void onItemClicked(int pos, Model_ChatRoom room) {
                ChatConversation.chatroom=room;
                startActivity(new Intent(HomeActivity.this,ChatConversation.class));
            }
        });
        add_new_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(HomeActivity.this,RoomActivity.class);
                startActivity(in);
            }
        });
        MyDatabase.getRoomBranch().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Model_ChatRoom>rooms=new ArrayList<>();
for(DataSnapshot item:dataSnapshot.getChildren())
{
    Model_ChatRoom room=item.getValue(Model_ChatRoom.class);
    rooms.add(room);
}
adapter.ChangeData(rooms);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(HomeActivity.this,"Error",Toast.LENGTH_LONG).show();
            }
        });


    }
}
