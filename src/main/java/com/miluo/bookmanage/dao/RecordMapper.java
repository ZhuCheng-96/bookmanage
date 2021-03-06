package com.miluo.bookmanage.dao;

import com.miluo.bookmanage.pojo.Record;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    int getBookCountByUserId(Integer userId);
}