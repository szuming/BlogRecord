package cn.szu.ming.service.impl;

import cn.szu.ming.dao.RecordMapper;
import cn.szu.ming.entity.Record;
import cn.szu.ming.service.RecordService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;

    @Override
    public void insertRecord(Record record) {
        recordMapper.insertRecord(record);
    }

    @Override
    public Record selectById(int id) {
        return recordMapper.selectById(id);
    }

    @Override
    public Record selectLast() {
        return recordMapper.selectLast();
    }

    @Override
    public List<Record> getRecords(int pageNum,int pageSize) {
        List<Record> list;
        PageHelper.startPage(pageNum,pageSize);
        list=recordMapper.getRecords();
        return list;
    }
}
