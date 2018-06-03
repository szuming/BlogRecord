package cn.szu.ming.service.impl;

import cn.szu.ming.dao.TagMapper;
import cn.szu.ming.entity.Tag;
import cn.szu.ming.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> getTags() {
        return tagMapper.getTags();
    }
}
