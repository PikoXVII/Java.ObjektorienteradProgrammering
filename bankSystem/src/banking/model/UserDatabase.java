package banking.model;

import java.io.*; 
import java.security.MessageDigest; // För att hasha lösenord
import java.security.NoSuchAlgorithmException;
import java.util.*; // List, map, formatter, etc.
import java.util.regex.*; // För att använda pattern och regex-validering

/**
 * UserDatabase sköter alla filoperationer enligt labbens krav:
 * - Läser och validerar users.txt
 * - Serialiserar användare till users.ser
 * - Hanterar saldo via balances.txt
 * - Loggar transaktioner
 */
public class UserDatabase {
    private static final String USER_INPUT_FILE = "users.txt";
    private static final String USER_SERIALIZED_FILE = "users.ser";
    private static final String BALANCE_FILE = "balances.txt";

    private Map<String, User> userMap = new HashMap<>();

    /**
     * Läser users.txt, validerar med regex, skapar User-objekt,
     * hashar lösenord och serialiserar till users.ser. Saldon sparas i balances.txt.
     */
    public void processUsersFromTxt() {
        List<String> validUsernames = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(USER_INPUT_FILE));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_SERIALIZED_FILE));
             BufferedWriter balanceWriter = new BufferedWriter(new FileWriter(BALANCE_FILE))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length != 7) continue; // felaktig rad

                String username = parts[0].trim();
                String password = parts[1].trim();
                String firstName = parts[2].trim();
                String lastName = parts[3].trim();
                String address = parts[4].trim();
                String phone = parts[5].trim();
                String balanceStr = parts[6].trim();

                if (isValid(username, password, firstName, lastName, address, phone, balanceStr)) {
                    int balance = Integer.parseInt(balanceStr);
                    User user = new User(username, firstName, lastName, address, phone, password);
                    userMap.put(username, user);
                    oos.writeObject(user); // serialisera användare
                    balanceWriter.write(username + "," + balance); // spara saldo
                    balanceWriter.newLine();
                    validUsernames.add(username);
                }
            }

            // Ta bort users.txt 
            new File(USER_INPUT_FILE).delete();

        } catch (IOException e) {
            System.err.println("Error processing users.txt: " + e.getMessage());
        }
    }

    /**
     * Autentiserar användare genom att jämföra hashat lösenord
     */
    public boolean authenticate(String username, String password) {
        if (userMap.isEmpty()) loadUsers();
        User user = userMap.get(username);
        return user != null && user.checkPassword(password);
    }

    /**
     * Läser in serialiserade användare från users.ser
     */
    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_SERIALIZED_FILE))) {
            while (true) {
                try {
                    User user = (User) ois.readObject();
                    userMap.put(user.getUsername(), user);
                } catch (EOFException eof) {
                    break; // slut på filen
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
    }

    /**
     * Hämtar användarens aktuella saldo från balances.txt
     */
    public int getBalance(String username) {
        try (Scanner scanner = new Scanner(new File(BALANCE_FILE))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts[0].equals(username)) {
                    return Integer.parseInt(parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading balance: " + e.getMessage());
        }
        return -1; // användare hittades inte
    }

    /**
     * Uppdaterar användarens saldo i balances.txt
     */
    public void updateBalance(String username, int newBalance) {
        Map<String, Integer> balances = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(BALANCE_FILE))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                balances.put(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            System.err.println("Error reading balances: " + e.getMessage());
        }

        balances.put(username, newBalance);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BALANCE_FILE))) {
            for (Map.Entry<String, Integer> entry : balances.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing balances: " + e.getMessage());
        }
    }

    /**
     * Loggar varje transaktion till en separat fil per användare
     */
    public void logTransaction(String username, String type, int amount) {
        String logFile = "history_" + username + ".log";
        try (Formatter formatter = new Formatter(new FileWriter(logFile, true))) {
            formatter.format("[%s] %s %d%n", new Date(), type.toUpperCase(), amount);
        } catch (IOException e) {
            System.err.println("Error writing transaction log: " + e.getMessage());
        }
    }

    /**
     * Regex baserad validering av alla fält i users.txt
     */
    private boolean isValid(String username, String password, String first, String last, String address, String phone, String balance) {
        return username.matches("^[a-zA-Z][\\w]{4,11}$") &&
                password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#]).{8,}$") &&
                first.matches("^[A-Za-z]+$") &&
                last.matches("^[A-Za-z]+$") &&
                address.matches("^[\\w .,\\-]{5,50}$") &&
                phone.matches("^\\+46\\d{7,9}$") &&
                balance.matches("^\\d+$");
    }
}
