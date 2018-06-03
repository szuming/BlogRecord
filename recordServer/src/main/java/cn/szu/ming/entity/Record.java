package cn.szu.ming.entity;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

public class Record implements Serializable {
    private static final long serialVersionUID = -7898194272883238670L;     //序列化id
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

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", time=" + time +
                ", note='" + note + '\'' +
                '}';
    }
}
