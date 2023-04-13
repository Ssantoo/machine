import java.time.LocalDateTime;

public class Item {

    private String itemName; //아이템 이름

    private String grade; //등급

    private LocalDateTime expirationTime;  //유통기한

    public Item(String itemName, String grade, LocalDateTime expirationTime) {
        this.itemName = itemName;
        this.grade = grade;
        this.expirationTime = expirationTime;
    }

    public boolean isExpired(LocalDateTime currentTime){
        return expirationTime.isBefore(currentTime);
    }

    @Override
    public String toString() {
        return "{" +
                 itemName + '\'' +
                 grade + '\'' +
                 expirationTime +
                '}';
    }
}
