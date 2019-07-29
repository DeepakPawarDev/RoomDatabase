package com.example.roomdatabase.viewModel;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;

import com.example.roomdatabase.BR;


public class Student extends BaseObservable {


    private String strName;
    private int intAge;
    private String strAddress;

    public Student(String strName, int intAge, String strAddress) {
        this.strName = strName;
        this.intAge = intAge;
        this.strAddress = strAddress;
    }

    public Student() {
    }

    @Bindable
    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
        notifyPropertyChanged(BR.strName);
    }

    @Bindable
    public int getIntAge() {
        return intAge;
    }

    public void setIntAge(int intAge) {
        this.intAge = intAge;
        notifyPropertyChanged(BR.intAge);
    }


    @Bindable
    public String getStrAddress() {
        return strAddress;
    }

    public void setStrAddress(String strAddress) {
        this.strAddress = strAddress;
        notifyPropertyChanged(BR.strAddress);
    }
}
