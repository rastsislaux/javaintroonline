package engineer.leepsky.javaintroonline.classes.aggregation.aggregation4;

import java.util.ArrayList;
import java.util.ListIterator;

public class Client {

    private String name;
    private ArrayList<Wallet> wallets = new ArrayList<>();

    enum sortMode {
        SORT_BY_NAME,
        SORT_BY_BALANCE
    }

    Client(String name) {
        this.name = name;
    }

    public int addWallet(Wallet wallet) {
        wallets.add(wallet);
        return wallets.size() - 1;
    }

    public Wallet getWallet(int index) {
        return wallets.get(index);
    }

    public Wallet getWalletByBalance(int balance) {
        for (Wallet wallet : wallets) {
            if (wallet.getBalance() == balance)
                return wallet;
        }
        return new Wallet("WALLET_NOT_FOUND");
    }

    public Wallet getWalletByName(String name) {
        for (Wallet wallet : wallets) {
            if (wallet.getName() == name)
                return wallet;
        }
        return new Wallet("WALLET_NOT_FOUND");
    }

    public void sortWallets(sortMode mode) {

        for (int i = 0; i < wallets.size(); i++) {
            for (int j = i + 1; j < wallets.size(); j++) {

                switch (mode) {
                    case SORT_BY_NAME -> {
                        if (wallets.get(i).getName().compareTo(wallets.get(j).getName()) > 0) {
                            Wallet temp = wallets.get(i);
                            wallets.set(i, wallets.get(j));
                            wallets.set(j, temp);
                        }
                    }
                    case SORT_BY_BALANCE -> {
                        if (wallets.get(i).getBalance() > wallets.get(j).getBalance()) {
                            Wallet temp = wallets.get(i);
                            wallets.set(i, wallets.get(j));
                            wallets.set(j, temp);
                        }
                    }
                }

            }
        }

    }

    public void printWalletList() {

        ListIterator<Wallet> it = wallets.listIterator();
        while (it.hasNext()) {
            System.out.println(it.nextIndex() + 1 + ". " + it.next().getName());
        }

    }

    public int getDebt() {
        int balance = 0;
        for (Wallet wallet : wallets) {
            if (wallet.getBalance() < 0) {
                balance += wallet.getBalance();
            }
        }
        return balance;
    }

    public int getMoney() {
        int balance = 0;
        for (Wallet wallet : wallets) {
            if (wallet.getBalance() > 0) {
                balance += wallet.getBalance();
            }
        }
        return balance;
    }

    public int getBalance() {

        return getDebt() + getMoney();

    }

}
