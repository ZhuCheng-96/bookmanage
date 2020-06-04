package com.miluo.bookmanage.service;

import com.miluo.bookmanage.utils.Result;

public interface RecordService {
    Result borrowOne(Integer userId, Integer bookId);
}
