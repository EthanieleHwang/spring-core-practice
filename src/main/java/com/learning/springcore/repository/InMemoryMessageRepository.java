package com.learning.springcore.repository;

import org.springframework.stereotype.Repository;

@Repository("dbMessageRepo")
public class InMemoryMessageRepository implements MessageRepository{

    @Override
    public String getMessage() {

        return "Data from InMemoryRepository(v1)";
    }
}
