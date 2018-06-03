package cn.szu.ming.dao;

import cn.szu.ming.entity.Record;

import java.util.List;


public interface RecordMapper {
    public void insertRecord(Record record);
    public Record selectById(int id);
    public List<Record> getRecords();
    public Record selectLast();
}
