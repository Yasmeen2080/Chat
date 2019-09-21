package com.example.yasmeen.chatapp.firebase.Daos;

import com.example.yasmeen.chatapp.firebase.Models.Model_user;
import com.example.yasmeen.chatapp.firebase.MyDatabase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by Yasmeen on 3/11/2019.
 */

public class UsersDao {

public static void insertUsers(Model_user user, OnSuccessListener onSuccessListener, OnFailureListener onFailureListener)
{
   DatabaseReference usernode= MyDatabase.getUsersBranch().push();
   user.setId(usernode.getKey());
   usernode.setValue(user).addOnSuccessListener(onSuccessListener).addOnFailureListener(onFailureListener);


}


}
