package cn.szu.ming.service;

import cn.szu.ming.entity.Record;

import java.util.List;

public interface RecordService {
    public void insertRecord(Record record);
    public Record selectById(int id);
    public List<Record> getRecords(int pageNum,int pageSize);
}
