package com.example.sonntt.cardbook.model;

import com.example.sonntt.cardbook.until.Categorizable;

/**
 * Created by sonntt on 12/18/15.
 */
public class DataMultiHeaderRecycle implements Categorizable {
    String year;
    String date;
    String Name;
    String Detail;

    public DataMultiHeaderRecycle(String year, String date, String name, String detail) {
        this.year = year;
        this.date = date;
        Name = name;
        Detail = detail;
    }

    public DataMultiHeaderRecycle() {
    }

    @Override
    public String getCategory() {
        return year;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }
}
