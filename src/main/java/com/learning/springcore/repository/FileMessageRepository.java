package com.learning.springcore.repository;

import org.springframework.stereotype.Repository;

@Repository("fileMessageRepo")
public class FileMessageRepository implements MessageRepository{
    @Override
    public String getMessage() {
        return "Data from FileMessageRepository (v2)";
    }
}
