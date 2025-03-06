import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
    
public class GUI_CrapsGame {
    private JFrame frame;
    private JButton rollDiceButton;
    private JTextField die1Field, die2Field, sumField, pointField;
    private JLabel die1Label, die2Label, sumLabel, pointLabel;
    private int point = 0; 
    private Random random;

    public GUI_CrapsGame() {
        frame = new JFrame("Craps Game");
        random = new Random();
        
        die1Label = new JLabel("Die 1:");
        die2Label = new JLabel("Die 2:");
        sumLabel = new JLabel("Sum:");
        pointLabel = new JLabel("Point:");

        die1Field = new JTextField(5);
        die2Field = new JTextField(5);
        sumField = new JTextField(5);
        pointField = new JTextField(5);

        die1Field.setEditable(false);
        die2Field.setEditable(false);
        sumField.setEditable(false);
        pointField.setEditable(false);

        rollDiceButton = new JButton("Roll Dice");
        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        frame.add(die1Label);
        frame.add(die1Field);
        frame.add(die2Label);
        frame.add(die2Field);
        frame.add(sumLabel);
        frame.add(sumField);
        frame.add(pointLabel);
        frame.add(pointField);
        frame.add(rollDiceButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    private void rollDice() {
        int die1 = random.nextInt(6) + 1; 
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;

        die1Field.setText(String.valueOf(die1));
        die2Field.setText(String.valueOf(die2));
        sumField.setText(String.valueOf(sum));

        if (point == 0) {
            if (sum == 7 || sum == 11) {
                JOptionPane.showMessageDialog(frame, "You Win!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                pointField.setText(""); 
            } else if (sum == 2 || sum == 3 || sum == 12) {
                JOptionPane.showMessageDialog(frame, "You Lose!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                pointField.setText(""); 
            } else {
                point = sum;
                pointField.setText(String.valueOf(point));
                JOptionPane.showMessageDialog(frame, "Your point is: " + point, "Point Phase", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            if (sum == point) {
                JOptionPane.showMessageDialog(frame, "You Win! You rolled your point.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                pointField.setText("");
                point = 0;
            } else if (sum == 7) {
                JOptionPane.showMessageDialog(frame, "You Lose! You rolled a 7.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                pointField.setText(""); 
                point = 0; 
            }
        }
    }

    public static void main(String[] args) {
        new GUI_CrapsGame();
    }
}

