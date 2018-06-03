package cn.szu.ming.dao;

import cn.szu.ming.entity.Tag;

import java.util.List;

public interface TagMapper {
    List<Tag> getTags();         //获得所有标签
}
