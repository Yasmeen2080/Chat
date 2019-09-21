package com.example.yasmeen.chatapp.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Yasmeen on 3/11/2019.
 */

public class MyDatabase {
    private static FirebaseDatabase firebaseDatabase;
public static FirebaseDatabase getInstance()
{
    if(firebaseDatabase==null)
    {
        firebaseDatabase=FirebaseDatabase.getInstance();

    }
    return firebaseDatabase;
}
final static String Users="users";
    final static String Rooms="rooms";
    final static String messages="messages";
public static DatabaseReference getUsersBranch()
{
return getInstance().getReference().child(Users);
}
    public static DatabaseReference getRoomBranch()
    {
        return getInstance().getReference().child(Rooms);
    }
    public static DatabaseReference getMessageBranch()
    {
        return getInstance().getReference().child(messages);
    }
}
