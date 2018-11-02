package com.soundtrap.songtrend.dto;

import java.io.Serializable;
import java.util.Date;

public class TimeSeries implements Serializable {

    private Date date;
    private int count;

    public TimeSeries(Date date, int count) {
        this.date = date;
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
