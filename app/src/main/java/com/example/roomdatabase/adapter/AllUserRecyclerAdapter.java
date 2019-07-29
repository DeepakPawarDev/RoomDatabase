package com.example.roomdatabase.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roomdatabase.R;
import com.example.roomdatabase.room.entities.User;

import java.util.List;


public class AllUserRecyclerAdapter extends RecyclerView.Adapter<AllUserRecyclerAdapter.MyViewHolder> {

    public List<User> users;
    LayoutInflater layoutInflater;
    Context context;
    private static final String TAG = "AllUserRecyclerAdapter";
    public AllUserRecyclerAdapter( Context context,List<User> users) {
        this.users=users;
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
        Log.i(TAG,"Size "+users.size()+"");
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View v = layoutInflater
                .inflate(R.layout.row_user, viewGroup, false);
        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        User user=users.get(i);
        myViewHolder.setData(user);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;
        TextView textViewName;

        public MyViewHolder(View v) {
            super(v);
            view = v;
            textViewName=(TextView)view.findViewById(R.id.text_view_name);
        }

        public void setData(User user){

            textViewName.setText(user.getStrName());

        }
    }
}
