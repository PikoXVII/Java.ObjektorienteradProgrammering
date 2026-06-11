package banking.gui;

import banking.model.UserDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankingGUI extends JFrame {

    private final JTextArea outputArea;
    private final JButton depositButton;
    private final JButton withdrawButton;
    private final JButton transferButton;
    private final JRadioButton showHistoryButton;
    private final JRadioButton hideHistoryButton;

    private final UserDatabase userDatabase;
    private String currentUser;

    public BankingGUI() {
        super("Simple Banking System");

        userDatabase = new UserDatabase();

        // === LOGIN ===
        int attempts = 0;
        boolean authenticated = false;

        while (attempts < 3 && !authenticated) {
            String username = JOptionPane.showInputDialog(
                    this,
                    "Enter username:",
                    "Login",
                    JOptionPane.PLAIN_MESSAGE
            );

            String password = JOptionPane.showInputDialog(
                    this,
                    "Enter password:",
                    "Login",
                    JOptionPane.PLAIN_MESSAGE
            );

            if (username == null || password == null) {
                System.exit(0);
            }

            if (userDatabase.authenticate(username, password)) {
                authenticated = true;
                currentUser = username;
            } else {
                attempts++;
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid username or password. Attempts left: " + (3 - attempts),
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        if (!authenticated) {
            JOptionPane.showMessageDialog(
                    this,
                    "Too many failed login attempts. Exiting...",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );
            System.exit(0);
        }

        // === INIT GUI ===
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ---------- TOP PANEL ----------
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("<<< Welcome to Simple Banking System >>>");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(welcomeLabel, BorderLayout.NORTH);

        outputArea = new JTextArea("Current Balance: " + userDatabase.getBalance(currentUser) + "\n");
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        // ---------- RADIO BUTTONS PANEL ----------
        showHistoryButton = new JRadioButton("Show History", true);
        hideHistoryButton = new JRadioButton("Hide History");

        ButtonGroup historyGroup = new ButtonGroup();
        historyGroup.add(showHistoryButton);
        historyGroup.add(hideHistoryButton);

        JPanel radioPanel = new JPanel();
        radioPanel.add(showHistoryButton);
        radioPanel.add(hideHistoryButton);
        topPanel.add(radioPanel, BorderLayout.SOUTH);

        hideHistoryButton.addActionListener(e ->
                outputArea.setText("Current Balance: " + userDatabase.getBalance(currentUser) + "\n")
        );

        add(topPanel, BorderLayout.CENTER);

        // ---------- BUTTONS PANEL ----------
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        transferButton = new JButton("Transfer");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(transferButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // ---------- BUTTON HANDLERS ----------
        ButtonHandler handler = new ButtonHandler();
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);

        setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String transactionType = "";

            if (e.getSource() == depositButton) {
                transactionType = "DEPOSIT";
            } else if (e.getSource() == withdrawButton) {
                transactionType = "WITHDRAW";
            } else if (e.getSource() == transferButton) {
                transactionType = "TRANSFER";
            }

            String input = JOptionPane.showInputDialog(
                    BankingGUI.this,
                    "Enter amount to " + transactionType.toLowerCase() + ":",
                    "Input Amount",
                    JOptionPane.PLAIN_MESSAGE
            );

            if (input == null) return;

            try {
                int amount = Integer.parseInt(input.trim());
                int currentBalance = userDatabase.getBalance(currentUser);

                if (amount <= 0) {
                    throw new IllegalArgumentException("Amount must be positive.");
                }
                if ((transactionType.equals("WITHDRAW") || transactionType.equals("TRANSFER")) && amount > currentBalance) {
                    throw new IllegalArgumentException("Insufficient balance.");
                }

                int newBalance = transactionType.equals("DEPOSIT") ?
                        currentBalance + amount : currentBalance - amount;

                userDatabase.updateBalance(currentUser, newBalance);
                userDatabase.logTransaction(currentUser, transactionType, amount);

                if (hideHistoryButton.isSelected()) {
                    outputArea.setText("Current Balance: " + newBalance + "\n");
                } else {
                    outputArea.append(capitalize(transactionType.toLowerCase()) + "ed " + amount + "\n");
                    outputArea.append("Updated Balance: " + newBalance + "\n");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        BankingGUI.this,
                        "Please enter a valid integer.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        BankingGUI.this,
                        ex.getMessage(),
                        "Transaction Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private String capitalize(String word) {
        if (word == null || word.isEmpty()) return word;
        return word.substring(0,1).toUpperCase() + word.substring(1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankingGUI::new);
    }
}
