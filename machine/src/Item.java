import java.time.LocalDateTime;

public class Item {

    private String itemName;

    private String grade;

    private LocalDateTime expirationTime;

    public Item(String itemName, String grade, LocalDateTime expirationTime) {
        this.itemName = itemName;
        this.grade = grade;
        this.expirationTime = expirationTime;
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
