package com.example.draw;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String name;
    private final Wallet wallet;
    private final Inventory inventory;
    private List<DrawRecord> drawRecords;

    public Member(String name, int wallet) {
        this.name = name;
        this.wallet = new Wallet(wallet);
        this.inventory = new Inventory();
        this.drawRecords = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public List<DrawRecord> getDrawRecords() {
        return this.drawRecords;
    }

    public void draw(Drawing drawing, int payment) {

        int drawsCount = payment / Drawing.getDrawPrice(); // 지불한 금액으로 뽑을 수 있는 횟수 계산

        wallet.useCash(payment);

        List<Object> drawnList = drawing.drawList(drawsCount);

        for (Object result : drawnList) {
            if (result instanceof Item) {

                Item item = (Item) result;

                inventory.addItem(item);

                System.out.println("상품: " + item.getItemName() + ", 등급: " + item.getGrade() + ", 유통기한: " + item.getExpirationTime());

            } else {
                System.out.println("결과: " + result);
            }
            drawRecords.add(new DrawRecord(LocalDateTime.now(), result));
        }
    }






}




