package com.learning.springcore.legacy;

public class LegacyService {
    private String configValue;
    public LegacyService(String configValue) {this.configValue = configValue;}
    public void doWork(){
        System.out.println("LegacyService working with:" + configValue);
    }
}
