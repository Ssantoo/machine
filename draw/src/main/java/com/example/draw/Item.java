package com.example.draw;

import java.time.LocalDateTime;

public class Item {

    private String itemName;
    private Grade itemGrade;
    private LocalDateTime expirationTime;

    public Item(String itemName, Grade itemGrade, LocalDateTime expirationTime) {
        this.itemName = itemName;
        this.itemGrade = itemGrade;
        this.expirationTime = expirationTime;
    }

    public String getItemName(){
        return itemName;
    }

    public Grade getGrade(){
        return itemGrade;
    }

    public LocalDateTime getExpirationTime(){
        return expirationTime;
    }

    public boolean isExpired(LocalDateTime currentTime){
        return expirationTime.isBefore(currentTime);
    }



}
