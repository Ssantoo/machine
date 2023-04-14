public class Wallet {

    private int cash; // 고객 금액

    private List<DrawRecord> drawRecords; // 뽑기기록


    public Wallet(int cash){
        this.cash = cash;
    }

    //전액확인
    public int getCash(){
        return cash;
    }

    //충전
    public void charge(int amount){
        cash += amount;
    }

    //차감
    public boolean payAble(int amount){
        if(cash >= amount){
            cash -= amount;
            return true;
        }
        return false;
    }

}
