package com.learning.springcore.service;

import com.learning.springcore.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    // ---方式一：字段注入---
    @Autowired
    private MessageRepository repoField;

    // ---方式二：Setter注入---
    private MessageRepository repoSetter;

    @Autowired
    public void setRepoSetter(MessageRepository repoSetter) {
        System.out.println("Injecting dependency via Setter for repoSetter ...");
        this.repoSetter = repoSetter;
    }

    @Override
    public void printMessage(){
        System.out.println("\n--- MessageService printMessage() called ---");
        if(repoField != null){
            System.out.println("Field repoField: " + repoField.getMessage());
        } else {
            System.out.println("Field repoField is null");
        }

        if(repoSetter != null){
            System.out.println("Setter repoSetter: " + repoSetter.getMessage());
        } else {
            System.out.println("Setter repoSetter is null");
        }
        System.out.println("----------------------------------------------------");
    }

    // 添加构造函数，观察注入时机
    public MessageServiceImpl()  {
        System.out.println("MessageServiceImpl Constructor called. repoField is "+repoField+",repoSetter is"+repoSetter);
    }
}
