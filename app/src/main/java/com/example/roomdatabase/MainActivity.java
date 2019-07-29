package com.example.roomdatabase;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabase.database.UserDatabase;
import com.example.roomdatabase.databinding.ActivityMainBinding;
import com.example.roomdatabase.room.entities.User;
import com.example.roomdatabase.viewModel.MainActivityViewModel;
import com.example.roomdatabase.viewModel.Student;

import static androidx.lifecycle.ViewModelProvider.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ActivityMainBinding activityMainBinding;
    MainActivityHandler mainActivityHandler;
    MainActivityViewModel mainActivityViewModel;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityHandler = new MainActivityHandler(this);
        activityMainBinding.setHandler(mainActivityHandler);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        LiveData<Student> studentLiveData = mainActivityViewModel.getStudentMutableLiveData();

        student=new Student();
        activityMainBinding.setStudent(student);

        studentLiveData.observe(this, new Observer<Student>() {
            @Override
            public void onChanged(Student student) {
                Log.i(TAG, "**************** " + student.getStrName());
            }
        });


    }


    public class MainActivityHandler {

        Context context;

        public MainActivityHandler(Context context) {
            this.context = context;
        }

        public void onSaveClick(View view) {

           mainActivityViewModel.setStudentData(student);
            Log.i(TAG, "******* Clicked saved button "+student.getStrName());
        }

    }
}
