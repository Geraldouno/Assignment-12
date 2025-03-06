import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TypingTutor extends JFrame {
    private JTextArea textArea;
    private String textTarget = "There are seven continents in the world.";
    private int correctKeyCount = 0; 
    private int incorrectKeyCount = 0;
    private JLabel textTargetLabel;

    public TypingTutor() {
        setTitle("Typing Tutor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        textTargetLabel = new JLabel(textTarget, SwingConstants.CENTER);
        textTargetLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        add(textTargetLabel, BorderLayout.NORTH);

        textArea = new JTextArea(5, 30);
        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.PLAIN, 20));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new GridLayout(5, 10));

        String[] keys = "QWERTYUIOPASDFGHJKLZXCVBNM".split("");

        for (String key : keys) {
            JButton keyButton = new JButton(key);
            keyButton.setFont(new Font("Serif", Font.PLAIN, 20));
            keyButton.setFocusPainted(false);
            keyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleKeyPress(keyButton, key.charAt(0)); 
                }
            });
            keyboardPanel.add(keyButton);
        }

        JButton spaceButton = new JButton("Space");
        spaceButton.setFont(new Font("Serif", Font.PLAIN, 20));
        spaceButton.setFocusPainted(false);
        spaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleKeyPress(spaceButton, ' ');
            }
        });
        keyboardPanel.add(spaceButton);

        add(keyboardPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void handleKeyPress(JButton keyButton, char keyChar) {
        String typedText = textArea.getText();
        
        if (typedText.length() < textTarget.length() &&
            Character.toUpperCase(textTarget.charAt(typedText.length())) == Character.toUpperCase(keyChar)) {
            correctKeyCount++;
            textArea.append(String.valueOf(keyChar));
            keyButton.setBackground(Color.GREEN);
        } else {
            incorrectKeyCount++;
            textArea.append(String.valueOf(keyChar));
            keyButton.setBackground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TypingTutor(); 
        });
    }
}
