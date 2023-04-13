public class Wallet {

    private int cash;

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
    public boolean pay(int amount){
        if(cash >= amount){
            cash -= amount;
            return true;
        }
        return false;
    }

}
