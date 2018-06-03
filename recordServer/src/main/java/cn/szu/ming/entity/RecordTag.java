package cn.szu.ming.entity;

public class RecordTag {
    private int id;
    private int rid;
    private int tid;
    private String tagName;

    public RecordTag() {
    }

    public RecordTag(int id, int rid, int tid, String tagName) {
        this.id = id;
        this.rid = rid;
        this.tid = tid;
        this.tagName = tagName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
