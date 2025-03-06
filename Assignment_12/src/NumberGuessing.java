import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
   
public class NumberGuessing {
    private static int targetNumber;
    private static int previousGuess = -1;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Guess the Number Game");
        JLabel labelInstruction = new JLabel("I picked a number between 1 and 1000. Can you guess my number?");
        JLabel labelGuess = new JLabel("Please enter your first guess:");
        JTextField guessTextField = new JTextField(10);
        JLabel labelFeedback = new JLabel("");
        JButton guessButton = new JButton("Guess");
        JButton buttonPlayAgain = new JButton("Play Again");

        initializeGame(guessTextField, labelFeedback, guessButton, buttonPlayAgain);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(guessTextField.getText());

                    if (guess == targetNumber) {
                        labelFeedback.setText("Correct!");
                        guessTextField.setEditable(false);
                        guessButton.setEnabled(false);
                    } else {
                        if (guess < targetNumber) {
                            labelFeedback.setText("Too Low");
                            guessTextField.setBackground(Color.BLUE);
                        } else {
                            labelFeedback.setText("Too High");
                            guessTextField.setBackground(Color.RED);
                        }

                        if (previousGuess != -1) {
                            int previousDiff = Math.abs(previousGuess - targetNumber);
                            int currentDiff = Math.abs(guess - targetNumber);

                            if (currentDiff < previousDiff) {
                                guessTextField.setBackground(Color.RED);  // Warmer
                            } else if (currentDiff > previousDiff) {
                                guessTextField.setBackground(Color.BLUE);  // Colder
                            }
                        }

                        previousGuess = guess;
                    }
                } catch (NumberFormatException ex) {
                    labelFeedback.setText("Please enter a valid number.");
                }
            }
        });

        buttonPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeGame(guessTextField, labelFeedback, guessButton, buttonPlayAgain);
                guessTextField.setEditable(true);
                guessButton.setEnabled(true);
                guessTextField.setBackground(Color.WHITE);
                labelFeedback.setText("");
                guessTextField.setText("");
            }
        });

        frame.add(labelInstruction);
        frame.add(labelGuess);
        frame.add(guessTextField);
        frame.add(labelFeedback);
        frame.add(guessButton);
        frame.add(buttonPlayAgain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    private static void initializeGame(JTextField guessTextField, JLabel feedbackLabel, JButton guessButton, JButton buttonPlayAgain) {
        Random random = new Random();
        targetNumber = random.nextInt(1000) + 1;
        previousGuess = -1;

        feedbackLabel.setText("");
        guessTextField.setText("");
        guessTextField.setEditable(true);
        guessTextField.setBackground(Color.WHITE);
        guessButton.setEnabled(true);
    }
} 

