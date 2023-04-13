
package com.finalproject.finalproject.collection;



//import java.util.List;
//
//public class Traveler {
//    private String travelerMail;
//    private Integer travelerBirthYear;
//    private String travelerGender;
//    private String travelerName;
//
//    private List<String> favoriteCategories;
//
//    public Traveler() {}
//
//    public Traveler(String travelerMail, String travelerName, int travelerBirthYear, String travelerGender , List<String> favoriteCategories) {
//        this.travelerMail = travelerMail;
//        this.travelerName = travelerName;
//        this.travelerBirthYear = travelerBirthYear;
//        this.travelerGender = travelerGender;
//        this.favoriteCategories = favoriteCategories;
//    }
//
//    public String getTravelerMail() {
//        return travelerMail;
//    }
//
//    public void setTravelerMail(String travelerMail) {
//        this.travelerMail = travelerMail;
//    }
//
//    public Integer getTravelerBirthYear() {
//        return travelerBirthYear;
//    }
//
//    public void setTravelerBirthYear(Integer travelerBirthYear) {
//        this.travelerBirthYear = travelerBirthYear;
//    }
//
//    public String getTravelerGender() {
//        return travelerGender;
//    }
//
//    public void setTravelerGender(String travelerGender) {
//        this.travelerGender = travelerGender;
//    }
//
//    public String getTravelerName() {
//        return travelerName;
//    }
//
//    public void setTravelerName(String travelerName) {
//        this.travelerName = travelerName;
//    }
//
//    public List<String> getFavoriteCategories() {
//        return favoriteCategories;
//    }
//    public void setFavoriteCategories(List<String> favoriteCategories) {
//        this.favoriteCategories =favoriteCategories;
//    }
//}


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;


public class Traveler implements Parcelable {
    @NonNull
    private String travelerMail;
    private Integer travelerBirthYear;
    private String travelerGender;
    private String travelerName;

    private List<String> favoriteCategories;

    public Traveler(){ }


    public Traveler(String travelerMail, String travelerName, int travelerBirthYear, String travelerGender , List<String> favoriteCategories) {
        this.travelerMail = travelerMail;
        this.travelerName = travelerName;
        this.travelerBirthYear = travelerBirthYear;
        this.travelerGender = travelerGender;
        this.favoriteCategories = favoriteCategories;
    }


    // Standard getters & setters

    protected Traveler(Parcel in) {
        travelerMail = in.readString();
        if (in.readByte() == 0) {
            travelerBirthYear = null;
        } else {
            travelerBirthYear = in.readInt();
        }
        travelerGender = in.readString();
        travelerName = in.readString();
    }

    public static final Creator<Traveler> CREATOR = new Creator<Traveler>() {
        @Override
        public Traveler createFromParcel(Parcel in) {
            return new Traveler(in);
        }

        @Override
        public Traveler[] newArray(int size) {
            return new Traveler[size];
        }
    };

    public Integer getTravelerBirthYear() { return travelerBirthYear; }
    public void setTravelerBirthYear(Integer travelerBirthYear) { this.travelerBirthYear = travelerBirthYear; }
    public String getTravelerGender() { return travelerGender; }
    public void setTravelerGender(String travelerGender) { this.travelerGender = travelerGender; }
    public String getTravelerMail() { return travelerMail; }
    public void setTravelerMail(String travelerMail) { this.travelerMail = travelerMail; }
    public String getTravelerName() { return travelerName; }
    public void setTravelerName(String travelerName) { this.travelerName = travelerName; }

    public List<String> getFavoriteCategories() {
        return favoriteCategories;
    }
    public void setFavoriteCategories(List<String> favoriteCategories) {
        this.favoriteCategories =favoriteCategories;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(travelerMail);
        if (travelerBirthYear == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(travelerBirthYear);
        }
        dest.writeString(travelerGender);
        dest.writeString(travelerName);
    }
}