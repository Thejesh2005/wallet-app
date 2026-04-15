public class WalletApp {

    public static double processTransaction(double balance, double amount, String type) {

        if (type.equalsIgnoreCase("credit")) {
            return balance + amount;
        }

        if (type.equalsIgnoreCase("debit")) {
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient Balance");
            }
            return balance - amount;
        }

        throw new IllegalArgumentException("Invalid Transaction Type");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Wallet Service Running...");

        while (true) {
            System.out.println("Updated Balance: " +
                processTransaction(1000, 200, "debit"));
            Thread.sleep(5000);
        }
    }
}