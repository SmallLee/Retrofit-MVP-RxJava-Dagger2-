package com.example.hecun.rxproject.entity;

import android.os.Parcel;

import com.example.hecun.rxproject.mvp.model.HttpResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 实体类
 */
public class MovieInfo extends HttpResult{
    public List<ResultsBean> results;

    public static class ResultsBean {

        public String poster_path;
        public boolean adult;
        public String overview;
        public String release_date;
        public int id;
        public String original_title;
        public String original_language;
        public String title;
        public String backdrop_path;
        public double popularity;
        public int vote_count;
        public boolean video;
        public double vote_average;
        public List<Integer> genre_ids;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeList(this.results);
    }

    public MovieInfo() {
    }

    protected MovieInfo(Parcel in) {
        super(in);
        this.results = new ArrayList<ResultsBean>();
        in.readList(this.results, ResultsBean.class.getClassLoader());
    }

    public static final Creator<MovieInfo> CREATOR = new Creator<MovieInfo>() {
        @Override
        public MovieInfo createFromParcel(Parcel source) {
            return new MovieInfo(source);
        }

        @Override
        public MovieInfo[] newArray(int size) {
            return new MovieInfo[size];
        }
    };

    @Override
    public String toString() {
        return "MovieInfo{" +
                "results=" + results +
                '}';
    }
}
