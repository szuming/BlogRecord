package cn.szu.ming.entity;

import java.sql.Timestamp;

public class Record {
    private int id;
    private String title;
    private String url;
    private Timestamp time;
    private String note;



    public Record() {
    }

    public Record(int id, String title, String url, Timestamp time, String note) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.time = time;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
