package com.example.draw;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Drawing {
    private final List<Item> items;
    private static final int PRICE = 100;
    private int bGradeDrawnCount;
    private final LocalDateTime currentTime;
    private Wallet wallet;
    private final Random random;

    public Drawing(List<Item> items) {
        this.items = items;
        this.currentTime = LocalDateTime.now();
        this.random = new Random();
    }

    public List<Object> draw(int drawsCount) {
        List<Object> drawnResults = new ArrayList<>();
        for (int i = 0; i < drawsCount; i++) {
            drawAction(drawnResults);
        }
        return drawnResults;
    }

    public void drawAction(List<Object> drawnResults) {
        wallet.useCash(PRICE);
        drawnResults(drawnResults);
    }

    public void drawnResults(List<Object> drawnResults) {
        Item drawnItem = drawItem();

        // 꽝일 경우
        if (drawnItem == null) {
            drawnResults.add("꽝");
        }

        // B등급일 경우
        if ("B".equals(drawnItem.getGrade())) {
            bGradeDrawnCount++;
        }
        drawnResults.add(drawnItem);
    }

    // 상품 뽑는 로직
    private Item drawItem() {
        Item result = null;
        double drawChance = random.nextDouble();

        if (drawChance < 0.9) {
            result = drawItemByGrade("A");
        }
        if (bGradeDrawnCount < 3) {
            result = drawItemByGrade("B");
        }

        return result;
    }

    // 등급별 상품을 뽑는 로직
    private Item drawItemByGrade(String grade) {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getGrade().equals(grade) && !item.isExpired(currentTime)) {
                availableItems.add(item);
            }
        }


        return availableItems.get(0);
    }
}
