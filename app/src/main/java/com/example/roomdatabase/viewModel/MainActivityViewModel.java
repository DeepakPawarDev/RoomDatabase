package com.example.roomdatabase.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private Student student = new Student();
    private List<Student> students;

    MutableLiveData<Student> studentMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Student> getStudentMutableLiveData() {
        studentMutableLiveData.setValue(student);
        return studentMutableLiveData;
    }

    public void setStudentData(Student studentData) {

        studentMutableLiveData.setValue(studentData);
    }

}
