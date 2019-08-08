package com.thanhnguyen.devjob.Model.ModelJob;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CountLevel implements Parcelable {

    public CountLevel(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    @SerializedName("level_job")
    @Expose
    private Integer levelJob;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("count")
    @Expose
    private Integer count;

    protected CountLevel(Parcel in) {
        if (in.readByte() == 0) {
            levelJob = null;
        } else {
            levelJob = in.readInt();
        }
        name = in.readString();
        if (in.readByte() == 0) {
            count = null;
        } else {
            count = in.readInt();
        }
    }

    public static final Creator<CountLevel> CREATOR = new Creator<CountLevel>() {
        @Override
        public CountLevel createFromParcel(Parcel in) {
            return new CountLevel(in);
        }

        @Override
        public CountLevel[] newArray(int size) {
            return new CountLevel[size];
        }
    };

    public Integer getLevelJob() {
        return levelJob;
    }

    public void setLevelJob(Integer levelJob) {
        this.levelJob = levelJob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (levelJob == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(levelJob);
        }
        dest.writeString(name);
        if (count == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(count);
        }
    }
}