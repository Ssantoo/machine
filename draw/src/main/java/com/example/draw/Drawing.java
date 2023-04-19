package com.example.draw;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Drawing {
    private final List<Item> items;

    private static final double A_GRADE_CHANCE = 0.9;
    private static final int PRICE = 100;
    private int bGradeDrawnCount;
    private final LocalDateTime currentTime;

    private final Random random;



    public Drawing(List<Item> items) {
        this.items = items;
        this.currentTime = LocalDateTime.now();
        this.random = new Random();
    }

    public static int getDrawPrice() {
        return PRICE;
    }

    public List<Object> drawList(int drawsCount) {
        List<Object> drawnResults = new ArrayList<>();
        for (int i = 0; i < drawsCount; i++) {
            Item drawnItem = drawItem();
            drawnResults(drawnResults, drawnItem);
        }
        return drawnResults;
    }

    public void drawnResults(List<Object> drawnResults, Item drawnItem) {

        // 꽝일 경우
        if (drawnItem == null) {
            drawnResults.add("꽝");
        } else {
            // B등급일 경우
             if (Grade.B.equals(drawnItem.getGrade())) {
                 bGradeDrawnCount++;
             }
            drawnResults.add(drawnItem);
        }
    }

    // 상품 뽑는 로직
    private Item drawItem() {

        double drawChance = random.nextDouble();
        double prizeChance = random.nextDouble();

        if (drawChance <= 0.5) {
            if (bGradeDrawnCount > 3 || prizeChance < A_GRADE_CHANCE) {
                return drawItemByGrade(Grade.A);
            } else {
                return drawItemByGrade(Grade.B);
            }
        }
        // 나머지 경우는 꽝으로 처리
        return null;
    }

    // 등급별 상품을 뽑는 로직
    private Item drawItemByGrade(Grade grade) {

        List<Item> availableItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getGrade().equals(grade) && !item.isExpired(currentTime)) {
                availableItems.add(item);
            }
        }

        if (availableItems.isEmpty()) {
            return null;
        }

        int randomIndex = random.nextInt(availableItems.size());
        return availableItems.get(randomIndex);
    }


}
