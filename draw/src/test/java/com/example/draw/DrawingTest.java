package com.example.draw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrawingTest {

    @Autowired List<Item> items;
    @Autowired Member member;
    @Autowired Drawing drawing;

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

        assertTrue(member.getWallet().getCash() < 0);
    }

    @Test
    public void 드로우아이템_테스트() {
        int initialCash = member.getWallet().getCash();
        int payment = 1000; // 10게임 (100 * 10)

        drawing = new Drawing(items);
        member.draw(drawing, payment);

        int remainingCash = member.getWallet().getCash();
        assertEquals(initialCash - payment, remainingCash);
    }

    @Test
    public void 항목만료_테스트() throws Exception {
        // given
        LocalDateTime now = LocalDateTime.of(2023, 4, 21, 0, 0, 0);
        Item expiredItem = new Item("EXPIRED_ITEM", Grade.A, LocalDateTime.of(2023, 3, 1, 0, 0, 0));

        // when
        boolean isExpired = expiredItem.isExpired(now);

        // then
        assertTrue(isExpired);
    }
    
    



}