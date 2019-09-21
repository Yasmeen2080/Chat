package com.example.yasmeen.chatapp.firebase.Daos;

import com.example.yasmeen.chatapp.firebase.Models.Message;
import com.example.yasmeen.chatapp.firebase.MyDatabase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

/**
 * Created by Yasmeen on 3/11/2019.
 */

public class MessagesDao {

public static void AddMessage(Message  message, OnSuccessListener onSuccessListener, OnFailureListener onFailureListener)
{


    DatabaseReference messagenode=MyDatabase.getMessageBranch().push();
    message.setId(messagenode.getKey());
    messagenode.setValue(message).addOnSuccessListener(onSuccessListener).addOnFailureListener(onFailureListener);

}
    public static Query getMessagebyRoomID(String  roomID)
    {


        return  MyDatabase.getMessageBranch().orderByChild("room_id").equalTo(roomID);

    }


}
