package com.example.yasmeen.chatapp.firebase.Daos;

import com.example.yasmeen.chatapp.firebase.Models.Model_ChatRoom;
import com.example.yasmeen.chatapp.firebase.MyDatabase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by Yasmeen on 3/11/2019.
 */

public class ChatsRoomDao {

    public static void AddRoom(Model_ChatRoom chatRoom, OnSuccessListener onSuccessListener, OnFailureListener onFailureListener)
    {
       DatabaseReference roomkey= MyDatabase.getRoomBranch().push();
       chatRoom.setId(roomkey.getKey());
       roomkey.setValue(chatRoom).addOnSuccessListener(onSuccessListener).addOnFailureListener(onFailureListener);


    }

}
