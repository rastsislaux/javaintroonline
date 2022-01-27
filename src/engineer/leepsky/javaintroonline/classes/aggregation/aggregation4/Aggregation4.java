package engineer.leepsky.javaintroonline.classes.aggregation.aggregation4;

/* Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
всем счетам, имеющим положительный и отрицательный балансы отдельно. */

public class Aggregation4 {

    public static void main(String[] args) {

        Client client1 = new Client("Firstman A."); // Клиент

        // Счета клиента
        int fWallet = client1.addWallet(new Wallet("Firstman's First Wallet"));
        int sWallet = client1.addWallet(new Wallet("Firstman's Second Wallet"));

        // Деньги на счёте
        client1.getWallet(fWallet).setBalance(+90000);
        client1.getWallet(sWallet).setBalance(-50000);

        // Блокировка счёта
        System.out.println("Trying to change balance on a blocked wallet:");
        client1.getWallet(fWallet).block();
        try {
            client1.getWallet(fWallet).setBalance(91000);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        client1.getWallet(fWallet).unblock();
        client1.getWallet(fWallet).setBalance(92000);

        // Поиск кошельков
        System.out.println("Looking for a wallet with -50.000 money:");
        System.out.println(client1.getWalletByBalance(-50000).getName());
        System.out.println("Looking for a wallet named \"Firstman's First Wallet\":");
        System.out.println(client1.getWalletByName("Firstman's First Wallet").getBalance());

        // Сортировка кошельков
        client1.sortWallets(Client.sortMode.SORT_BY_NAME);
        System.out.println("Wallets sorted alphabetically:");
        client1.printWalletList();
        client1.sortWallets(Client.sortMode.SORT_BY_BALANCE);
        System.out.println("Wallets sorted by balance:");
        client1.printWalletList();

        // Общая сумма
        System.out.println("Balance: " + client1.getBalance());

        // Сумма по негативным счетам
        System.out.println("Only negative: " + client1.getDebt());

        // Сумма по позитивным счетам
        System.out.println("Only posititve: " + client1.getMoney());

    }

}
