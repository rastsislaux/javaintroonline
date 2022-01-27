package engineer.leepsky.javaintroonline.classes.aggregation.aggregation4;

public class Wallet {

    private String name;
    private int balance = 0;
    private boolean blocked = false;

    Wallet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (!blocked) {
            this.balance = balance;
        } else {
            throw new RuntimeException("Blocked wallet's balanced can not be changed.");
        }
    }

    public void block() {
        blocked = true;
    }

    public void unblock() {
        blocked = false;
    }

}
