import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Drawing {

    private List<Item> items; // 상품리스트
    private Wallet wallet; // 고객 지갑 금액

    private Random random;  //랜덤값 생성

    final int PRICE = 100; // 뽑기 1회당 차감되는 금액

    public Drawing(List<Item> items, Wallet wallet) {
        this.items = items;
        this.wallet = wallet;
        random = new Random();
    }

    public List<Item> draw(int draws, LocalDateTime currentTime){
        List<Item> drawnItems = new ArrayList<>();

        for(int i =0; i<draws; i++){
            if(wallet.pay(100)){
                Item drawnItem = drawItem(currentTime);
                if(drawnItem != null){
                    drawnItems.add(drawnItem);
                }
            }
        }

        return drawnItems;
    }


    





}
