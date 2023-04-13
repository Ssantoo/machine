import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Item {

    private String itemName; //아이템 이름

    private Grade grade; //등급

    private LocalDateTime expirationTime;  //유통기한

    private Random random;

    public Item(String itemName, Grade grade, LocalDateTime expirationTime) {
        this.itemName = itemName;
        this.grade = grade;
        this.expirationTime = expirationTime;
    }

    public String getName(){
        return itemName;
    }

    public Grade getGrade(){
        return grade;
    }

    public LocalDateTime getExpirationTime(){
        return expirationTime;
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
