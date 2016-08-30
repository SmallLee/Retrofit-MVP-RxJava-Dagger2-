package com.example.hecun.rxproject.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hecun on 2016/8/19.
 */
public class HttpResult implements Parcelable {
    public int page;
    public int total_results;
    public int total_pages;
    public HttpResult() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.page);
        dest.writeInt(this.total_results);
        dest.writeInt(this.total_pages);
    }

    protected HttpResult(Parcel in) {
        this.page = in.readInt();
        this.total_results = in.readInt();
        this.total_pages = in.readInt();
    }

    public static final Creator<HttpResult> CREATOR = new Creator<HttpResult>() {
        @Override
        public HttpResult createFromParcel(Parcel source) {
            return new HttpResult(source);
        }

        @Override
        public HttpResult[] newArray(int size) {
            return new HttpResult[size];
        }
    };
}
