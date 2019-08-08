package com.thanhnguyen.devjob.Model.ModelJob;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountSkill implements Parcelable {

    public CountSkill(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    @SerializedName("cate_id")
    @Expose
    private Integer cateId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("count")
    @Expose
    private Integer count;

    protected CountSkill(Parcel in) {
        if (in.readByte() == 0) {
            cateId = null;
        } else {
            cateId = in.readInt();
        }
        name = in.readString();
        if (in.readByte() == 0) {
            count = null;
        } else {
            count = in.readInt();
        }
    }

    public static final Creator<CountSkill> CREATOR = new Creator<CountSkill>() {
        @Override
        public CountSkill createFromParcel(Parcel in) {
            return new CountSkill(in);
        }

        @Override
        public CountSkill[] newArray(int size) {
            return new CountSkill[size];
        }
    };

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
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
        if (cateId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cateId);
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