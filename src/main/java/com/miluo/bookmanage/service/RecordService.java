package com.miluo.bookmanage.service;

import com.miluo.bookmanage.utils.Result;

public interface RecordService {
    Integer borrowOne(Integer userId, Integer bookId);

    Integer returnOne(Integer userId, Integer bookId);
}
