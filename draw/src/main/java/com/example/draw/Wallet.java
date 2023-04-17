package com.example.draw;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private int cash; //현 금액

    public Wallet(int initialCash) {
        this.cash = initialCash;
    }

    //돈 충전
    public void charge(int amount){
        this.cash += amount;
    }

    //돈 사용
    public void useCash(int amount){
        if(this.cash < amount){
            throw new RuntimeException("금액부족");
        }
        this.cash -= amount;
    }

    //잔액
    public int getCash(){
        return this.cash;
    }

}
