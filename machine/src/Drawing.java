import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Drawing {

    private List<Item> items; // 상품리스트
    private Wallet wallet; // 고객 지갑 금액

    private Random random;  //랜덤값 생성

    private LocalDateTime currentTime;
    private int bGradeDrawnCount; // B가 뽑히는 횟수

    private static final int price = 100; // 뽑기 1회당 차감되는 금액

    public Drawing(List<Item> items, Wallet wallet, LocalDateTime currentTime) {
        this.items = items;
        this.wallet = wallet;
        random = new Random();
    }


    //뽑기할 때 호출되는 메서드
    public List<Object> draw(int drawsCount) {
        List<Object> drawnResults = new ArrayList<>();
        for (int i = 0; i < drawsCount; i++) {
            drawAction(drawnResults);
        }
        return drawnResults;
    }

    public void drawAction(List<Object> drawnResults){
        checkAblePay();
        drawnResults(drawnResults);
    }

    public void checkAblePay(){
        if(!wallet.payAble(price)){
            throw new RuntimeException("금액부족");
        }
    }

    public void drawnResults(List<Object> drawnResults){
        Item drawnItem = drawItem();

        //꽝일경우
        if(drawnItem == null){
            drawnResults.add("꽝");
        }

        //B등급일경우
        if(drawnItem.getGrade().equals("B")){
            bGradeDrawnCount++;
        }
        drawnResults.add(drawnItem);

    }

    //상품 뽑는 로직
    private Item drawItem() {

        Item result = null;

        double drawChance = random.nextDouble();

        if (drawChance < 0.9) {
            result = drawItemByGrade("A", currentTime);
        } else if (bGradeDrawnCount < 3) {
            result = drawItemByGrade("B", currentTime);
        }

        return result;
    }

    //등급별 상품을 뽑는 로직
    private Item drawItemByGrade(String grade, LocalDateTime currentTime) {

        List<Item> availableItems = new ArrayList<>();
        for(Item item : items){
            if(item.getGrade().equals(grade) && !item.isExpired(currentTime)) {
                availableItems.add(item);
            }
        }
        int size = random.nextInt(availableItems.size());
        return availableItems.get(size);
    }





}
