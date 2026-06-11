package banking.model;

public class BankAccountManager {
    private int balance;

    public BankAccountManager() {
        // Startsaldo enligt labbens exempel
        this.balance = 100000;
    }

    public int getBalance() {
        return balance;
    }

    public void processTransaction(String type, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }

        switch (type.toLowerCase()) {
            case "deposit":
                balance += amount;
                break;

            case "withdraw":
                if (amount > balance) {
                    throw new IllegalArgumentException("Insufficient balance for withdrawal.");
                }
                balance -= amount;
                break;

            case "transfer":
                if (amount > balance) {
                    throw new IllegalArgumentException("Insufficient balance for transfer.");
                }
                balance -= amount;
                break;

            default:
                throw new IllegalArgumentException("Invalid transaction type: " + type);
        }
    }
}
