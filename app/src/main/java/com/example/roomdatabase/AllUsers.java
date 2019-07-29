package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.example.roomdatabase.adapter.AllUserRecyclerAdapter;
import com.example.roomdatabase.database.UserDatabase;
import com.example.roomdatabase.room.entities.User;

import java.util.ArrayList;
import java.util.List;

public class AllUsers extends AppCompatActivity {
    private RecyclerView recycler;
    private static final String TAG = "AllUsers";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        initializeActivity();
        setAdapter();
    }

    private void setAdapter() {

        List<User> userList = new ArrayList<>();
        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        Log.i(TAG,"Start");
        for (User user1 : userDatabase.userDAO().loadAllUsers()) {
            userList.add(user1);
            Log.i(TAG,user1.getStrName());
        }

        recycler.setAdapter(new AllUserRecyclerAdapter(this,userList));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);

    }

    private void initializeActivity() {
        recycler = (RecyclerView) findViewById(R.id.recycler_users);
    }
}
