package com.example.draw;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Drawing {
    private final List<Item> items;

    private static final double A_GRADE_CHANCE = 0.9;
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
        Item drawnItem = drawItem();
        drawnResults(drawnResults, drawnItem);
    }

    public void drawnResults(List<Object> drawnResults, Item drawnItem) {

        // 꽝일 경우
        if (drawnItem == null) {
            drawnResults.add("꽝");
        } else {
            // B등급일 경우
             if ("B".equals(drawnItem.getGrade())) {
                 bGradeDrawnCount++;
             }
            drawnResults.add(drawnItem);
        }
    }

    // 상품 뽑는 로직
    private Item drawItem() {

        double drawChance = random.nextDouble();

        if (drawChance < 0.5) {
            double prizeChance = random.nextDouble();
            if (bGradeDrawnCount < 3 && prizeChance >= A_GRADE_CHANCE) {
                return drawItemByGrade("B");
            } else {
                return drawItemByGrade("A");
            }
        } else {
            return null;
        }
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
