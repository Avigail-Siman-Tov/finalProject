
package com.finalproject.finalproject.collection;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
//import androidx.room.Entity;
//import androidx.room.Ignore;
//import androidx.room.PrimaryKey;

public class Traveler {
    private String travelerMail;
    private Integer travelerBirthYear;
    private String travelerGender;
    private String travelerName;

    public Traveler() {}

    public Traveler(String travelerMail, String travelerName, int travelerBirthYear, String travelerGender) {
        this.travelerMail = travelerMail;
        this.travelerName = travelerName;
        this.travelerBirthYear = travelerBirthYear;
        this.travelerGender = travelerGender;
    }

    public String getTravelerMail() {
        return travelerMail;
    }

    public void setTravelerMail(String travelerMail) {
        this.travelerMail = travelerMail;
    }

    public Integer getTravelerBirthYear() {
        return travelerBirthYear;
    }

    public void setTravelerBirthYear(Integer travelerBirthYear) {
        this.travelerBirthYear = travelerBirthYear;
    }

    public String getTravelerGender() {
        return travelerGender;
    }

    public void setTravelerGender(String travelerGender) {
        this.travelerGender = travelerGender;
    }

    public String getTravelerName() {
        return travelerName;
    }

    public void setTravelerName(String travelerName) {
        this.travelerName = travelerName;
    }
}