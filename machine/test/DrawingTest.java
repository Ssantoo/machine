import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DrawingTest {

    private Wallet wallet;
    private List<Item> items;
    private Drawing drawing;

    LocalDateTime currentTime = LocalDateTime.of(2023, 4, 13, 0, 0);

//    @BeforeEach
//    public void 초기_세팅(){
//        wallet = new Wallet(10000); //고객 지갑 10,000 충전
//
//        items = new ArrayList<>();
//        items.add(new Item("CHICKEN", "B", LocalDateTime.of(2023, 12, 1, 0 , 0)));
//        items.add(new Item("CIDER", "A", LocalDateTime.of(2023, 10, 1, 0 , 0)));
//        items.add(new Item("COLA", "A", LocalDateTime.of(2023, 9, 1, 0 , 0)));
//        items.add(new Item("PIZZA", "A", LocalDateTime.of(2023, 3, 1, 0 , 0)));
//
//        drawing = new Drawing(items, wallet);
//    }
//
//    @Test
//    public void 지갑잔액_부족() throws Exception {
//        //given
//        wallet.payAble(100000);
//        //when
//        List<Object> results = drawing.draw(1, currentTime);
//        //then
//        Assertions.assertEquals(0, results.size());
//    }
//
//    @Test
//    public void 게임() {
//        //추첨 결과를 담기
//        List<String> drawnItemNames = new ArrayList<>();
//
//        //2개의 아이템을추첨
//        List<Object> results = drawing.draw(2, currentTime);
//        Assertions.assertEquals(2, results.size());
//
//        //추첨 결과 상품이거나 꽝
//        for(Object result : results){
//            assertTrue(result instanceof Item || result instanceof String);
//            if(result instanceof Item){
//                Item item = (Item) result;
//                drawnItemNames.add(item.getName());
//            }
//        }
//
//    }



}