package com.learning.springcore.service;

import com.learning.springcore.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MessageServiceImpl implements MessageService {

    // ---方式一：字段注入---
    @Autowired
    @Qualifier("fileMessageRepo")
    private MessageRepository repoField;

    // ---方式二：Setter注入---
    private MessageRepository repoSetter;

    private final MessageRepository messageRepository ;

    public MessageServiceImpl(@Qualifier("fileMessageRepo") MessageRepository messageRepository){
        System.out.println("MessageServiceImpl Constructor: Injecting MessageRepository: " + messageRepository.getClass().getName());
        this.messageRepository = messageRepository;
    }

    @Autowired
    public void setRepoSetter(@Qualifier("fileMessageRepo") MessageRepository repoSetter) {
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
        System.out.println("Message from injected repository:" + messageRepository.getMessage());
    }
    @PostConstruct
    public void initialize() {
        System.out.println("00000[Bean Lifecycle] MessageServiceImpl: @PostConstruct : Dependencies injected (if any),ready for initialization!");
        System.out.println("00000[Bean Lifecycle - MessageServiceImpl] Initializing resources...");
    }
//    // 添加构造函数，观察注入时机
//    public MessageServiceImpl(MessageRepository messageRepository)  {
//        this.messageRepository = messageRepository;
//        System.out.println("MessageServiceImpl Constructor called. repoField is "+repoField+",repoSetter is"+repoSetter);
//    }
}
