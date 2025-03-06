
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_ATM extends JFrame {
    private double balance = 1000;  // Initial balance
    private JTextField pinField;
    private JLabel balanceLabel;
    private JLabel messageLabel;

    public GUI_ATM() {
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Message Panel
        JPanel messagePanel = new JPanel();
        messageLabel = new JLabel("Welcome to the ATM");
        messagePanel.add(messageLabel);
        add(messagePanel, BorderLayout.NORTH);

        // Main Panel (Balance & PIN)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));
        balanceLabel = new JLabel("Balance: $" + balance);
        mainPanel.add(balanceLabel);

        JPanel pinPanel = new JPanel();
        pinPanel.add(new JLabel("Enter PIN: "));
        pinField = new JTextField(6);
        pinPanel.add(pinField);
        mainPanel.add(pinPanel);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        JButton withdrawButton = new JButton("Withdraw Cash");
        JButton depositButton = new JButton("Deposit Envelope");

        // Withdraw Button Action
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter withdrawal amount:");
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (amount <= balance) {
                        balance -= amount;
                        balanceLabel.setText("Balance: $" + balance);
                        messageLabel.setText("Cash Withdrawn: $" + amount);
                    } else {
                        messageLabel.setText("Insufficient funds.");
                    }
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Invalid input.");
                }
            }
        });

        // Deposit Button Action
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter deposit amount:");
                try {
                    double amount = Double.parseDouble(amountStr);
                    balance += amount;
                    balanceLabel.setText("Balance: $" + balance);
                    messageLabel.setText("Deposit Successful: $" + amount);
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Invalid input.");
                }
            }
        });

        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        mainPanel.add(buttonPanel);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI_ATM();  // Run the ATM application
    }
}

