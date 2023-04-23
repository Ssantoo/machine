package com.example.draw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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

        drawing = new Drawing(items); // Drawing 객체 초기화

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

    @Test
    public void 항목만료안된_테스트() throws Exception {
        // given
        LocalDateTime now = LocalDateTime.of(2023, 4, 21, 0, 0, 0);
        Item notExpiredItem = new Item("NOT_EXPIRED_ITEM", Grade.A, LocalDateTime.of(2023, 5, 1, 0, 0, 0));

        // when
        boolean isExpired = notExpiredItem.isExpired(now);

        // then
        assertFalse(isExpired);
    }

    @Test
    public void B항목_테스트() throws Exception {
        //given
        int drawsCount = 1000;

        // 무작위 요소를 제어하기 위해 Drawing 클래스에 대한 목 객체 생성
        Drawing mockDrawing = Mockito.mock(Drawing.class);

        // drawList() 메소드가 항상 3개의 Grade.B 항목을 반환하도록 설정
        List<Item> mockDrawnResults = new ArrayList<>();
        mockDrawnResults.add(new Item("B_ITEM1", Grade.B, LocalDateTime.now()));
        mockDrawnResults.add(new Item("B_ITEM2", Grade.B, LocalDateTime.now()));
        mockDrawnResults.add(new Item("B_ITEM3", Grade.B, LocalDateTime.now()));
        mockDrawnResults.add(new Item("B_ITEM4", Grade.B, LocalDateTime.now()));
        mockDrawnResults.add(new Item("B_ITEM5", Grade.B, LocalDateTime.now()));
        mockDrawnResults.add(new Item("B_ITEM6", Grade.B, LocalDateTime.now()));
        mockDrawnResults.add(new Item("B_ITEM7", Grade.B, LocalDateTime.now()));
        when(mockDrawing.drawList(drawsCount)).thenReturn(Collections.singletonList(mockDrawnResults));


        //when
        List<Object> drawnResults = drawing.drawList(drawsCount);

        //then
        long bGradeDrawnCount = drawnResults.stream()
                .filter(result -> result instanceof Item && ((Item) result).getGrade() == Grade.B)
                .count();

        assertTrue(bGradeDrawnCount <= 3, "3개?");

    }
        
}




