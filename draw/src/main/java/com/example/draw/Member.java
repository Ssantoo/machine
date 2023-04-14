package com.example.draw;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private Wallet wallet;
    private Drawing draw;

    public Member(String name, int initialCash) {
        this.name = name;
        this.wallet = new Wallet(initialCash);
        this.draw = new Drawing(new ArrayList<>());
    }

    public String getName(){
        return name;
    }

    public Wallet getWallet(){
        return wallet;
    }

    public Drawing getDraw(){
        return draw;
    }

    public void play(int drawsCount){
        List<Object> drawnList = draw.draw(drawsCount);
        wallet.useCash(drawsCount * 100);
        for(Object result : drawnList) {
            if (result instanceof Item) {
                Item item = (Item) result;
                System.out.println(item.getItemName() + item.getGrade() + item.getExpirationTime());
            } else {
                System.out.println(result);
            }
        }
    }





}
