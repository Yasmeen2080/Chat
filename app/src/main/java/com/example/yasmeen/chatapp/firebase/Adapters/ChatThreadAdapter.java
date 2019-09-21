package com.example.yasmeen.chatapp.firebase.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yasmeen.chatapp.R;
import com.example.yasmeen.chatapp.firebase.DataHolder;
import com.example.yasmeen.chatapp.firebase.Models.Message;
import com.example.yasmeen.chatapp.firebase.Models.Model_ChatRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yasmeen on 3/11/2019.
 */

public class ChatThreadAdapter extends RecyclerView.Adapter<ChatThreadAdapter.viewHolder> {
    public ChatThreadAdapter(List<Message> messages) {
        this.messages = messages;
    }

    List<Message> messages;
public static final int incoming=5;
public static final int outgoing=20;

    public ChatThreadAdapter() {
    }

    @Override
    public int getItemViewType(int position) {

        Message message=messages.get(position);
        if(message.getSender_id().equals(DataHolder.currentuser.getId()))
            return outgoing;
        return incoming;
    }
View view=null;
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==incoming)
        {
             view= LayoutInflater.from(parent.getContext()).inflate(R.layout.message_incoming,parent,false);
        }
        else if(viewType==outgoing)
        {
             view= LayoutInflater.from(parent.getContext()).inflate(R.layout.message_outgoing,parent,false);
        }
return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        Message message=messages.get(position);
int viewType=getItemViewType(position);
holder.sendername.setText(message.getSendername());
holder.content.setText(message.getContent());
holder.time.setText(message.getTime());
    }
public void ChangeData(List<Message>messages)
{
    this.messages=messages;
    notifyDataSetChanged();
}
    public void AddData(Message message)
    {
        if (messages==null)
            messages=new ArrayList<>();
      messages.add(message);
      notifyItemChanged(messages.size()-1);
    }

    @Override
    public int getItemCount() {
        if(messages==null)
            return 0 ;
        return messages.size();
    }


    public interface OnItemClickListner {
        void onItemClicked(int pos, Model_ChatRoom chatRoom);


    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView sendername, content, time;

        public viewHolder(View itemView) {
            super(itemView);
            sendername = itemView.findViewById(R.id.sender_name);
            content = itemView.findViewById(R.id.message_contet);
            time = itemView.findViewById(R.id.message_time);
        }
    }
}