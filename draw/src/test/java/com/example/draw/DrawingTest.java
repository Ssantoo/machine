package com.example.draw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrawingTest {

    private List<Item> items;
    private Member member;
    private Drawing drawing;

    @BeforeEach
    public void 초기세팅(){
        items = new ArrayList<>();
        items.add(new Item("CHICKEN", Grade.B, LocalDateTime.of(2023, 4, 23, 2, 20, 19)));
        items.add(new Item("CIDER", Grade.A, LocalDateTime.of(2023, 4, 23, 2, 20, 19)));
        items.add(new Item("COLA", Grade.A, LocalDateTime.of(2023, 4, 23, 2, 20, 19)));
        items.add(new Item("PIZZA", Grade.A, LocalDateTime.of(2023, 3, 23, 2, 20, 19)));

        member = new Member("조현재", 10000);


    }

    @Test
    public void 잔액_확인(){
        assertEquals(10000, member.getWallet().getCash());
    }

    @Test
    public void 충전_확인(){
        member.getWallet().charge(5000);
        assertEquals(15000, member.getWallet().getCash());
    }

    @Test
    public void 돈사용_확인(){
        member.getWallet().useCash(5000);
        assertEquals(5000,member.getWallet().getCash());
    }

    @Test
    public void 초과금액사용_확인(){
        member.getWallet().useCash(15000);
        assertEquals(-5000,member.getWallet().getCash());
    }

    @Test
    public void 드로우결과_확인(){


    }



}