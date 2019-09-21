package com.example.yasmeen.chatapp.firebase.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yasmeen.chatapp.R;
import com.example.yasmeen.chatapp.firebase.Models.Model_ChatRoom;

import java.util.List;

/**
 * Created by Yasmeen on 3/11/2019.
 */

public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.viewHolder>{

    public RoomsAdapter(List<Model_ChatRoom> chatRooms) {
        this.chatRooms = chatRooms;
    }
public void ChangeData(List<Model_ChatRoom>
                       newrooms)
{
    this.chatRooms=newrooms;
    notifyDataSetChanged();
}
    OnItemClickListner onItemClickListner;

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }
    List<Model_ChatRoom>chatRooms;
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.room_cardview,parent,false);
    return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {
        final Model_ChatRoom chatroom=chatRooms.get(position);
    holder.name.setText(chatroom.getName());
holder.desc.setText(chatroom.getDesc());
if(onItemClickListner!=null)
{
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onItemClickListner.onItemClicked(position,chatroom);
        }
    });
}
    }


    @Override
    public int getItemCount() {
    if(chatRooms==null)
        return 0;
    return  chatRooms.size();
    }
    public interface OnItemClickListner{
 void onItemClicked(int pos,Model_ChatRoom chatRoom);


    }
    class viewHolder extends RecyclerView.ViewHolder{
TextView name,desc;

        public viewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            desc=itemView.findViewById(R.id.desc);
        }
    }



}
