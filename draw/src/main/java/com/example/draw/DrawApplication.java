package com.example.draw;

import java.time.LocalDateTime;
import java.util.*;


public class DrawApplication {

    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        items.add(new Item("CHICKEN", "B", LocalDateTime.of(2023, 4, 23, 2, 20, 19)));
        items.add(new Item("CIDER", "A", LocalDateTime.of(2023, 4, 23, 2, 20, 19)));
        items.add(new Item("COLA", "A", LocalDateTime.of(2023, 4, 23, 2, 20, 19)));
        items.add(new Item("PIZZA", "A", LocalDateTime.of(2023, 3, 23, 2, 20, 19)));

        Scanner scanner = new Scanner(System.in);
        Member member = new Member("조현재", 10000);
        Drawing drawing = new Drawing(items);

        while (member.getWallet().getCash() >= Drawing.getDrawPrice()) {
            System.out.println("현재 잔액: " + member.getWallet().getCash() + "원");
            System.out.print("게임에 사용할 금액을 입력하세요 (종료하려면 0 입력): ");
            int payment = 0;

            try {
                payment = scanner.nextInt();
                if (payment % 100 != 0) {
                    System.out.println("드로우는 100원입니다.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("올바른 금액을 입력해주세요.");
                scanner.nextLine();
                continue;
            }

            if (payment == 0) {
                break;
            }

            if (payment <= member.getWallet().getCash()) {
                member.draw(drawing, payment);
            } else {
                System.out.println("잔액이 부족합니다.");
                System.out.println("가지고 있는 금액 : " + member.getWallet().getCash() +"원");

            }
        }
        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
}
