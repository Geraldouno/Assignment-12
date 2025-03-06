
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICalculator extends JFrame {

    // Display field for the calculator
    private JTextField display;

    // Constructor to set up the calculator UI
    public GUICalculator() {
        setTitle("Calculator"); // Set the title of the window
        setSize(400, 500); // Set the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        setLocationRelativeTo(null); // Center the window on screen

        // Create a panel for the display and buttons
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // Use BorderLayout to place the display and buttons

        // Display field to show input and results
        display = new JTextField();
        display.setBackground(Color.white);
        display.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font size
        display.setEditable(false); // Make the display field non-editable
        panel.add(display, BorderLayout.NORTH); // Add the display to the top of the panel

        // Create a panel for the calculator buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 grid for buttons

        // Define buttons for the calculator
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Create buttons dynamically based on buttonLabels array
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size for the buttons
            button.addActionListener(new ButtonClickListener()); // Add event listener for button clicks
            buttonPanel.add(button); // Add button to the button panel
        }

        // Add the button panel to the main panel
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        add(panel);

        // Set the frame visible
        setVisible(true);
    }

    // Button click listener class
    private class ButtonClickListener implements ActionListener {
        private StringBuilder currentInput = new StringBuilder(); // Holds the current input text

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // Handle number and operator inputs
            if ("0123456789.".contains(command)) {
                currentInput.append(command);
                display.setText(currentInput.toString());
            }
            // Handle "=" button (calculate the result)
            else if (command.equals("=")) {
                try {
                    String result = evaluateExpression(currentInput.toString());
                    display.setText(result); // Display the result
                    currentInput.setLength(0); // Clear the current input after calculation
                    currentInput.append(result); // Store the result for further calculations
                } catch (Exception ex) {
                    display.setText("Error"); // Display error if the expression is invalid
                }
            }
            // Handle operator buttons
            else if ("+-*/".contains(command)) {
                currentInput.append(" " + command + " "); // Add space between numbers and operators
                display.setText(currentInput.toString());
            }
        }

        // Method to evaluate the mathematical expression
        private String evaluateExpression(String expression) {
            // Replace division symbol to avoid issues with Java's division operator
            expression = expression.replaceAll("/", " / ");
            expression = expression.replaceAll("\\*", " * ");

            try {
                // Using Java's scripting engine to evaluate the mathematical expression
                javax.script.ScriptEngineManager mgr = new javax.script.ScriptEngineManager();
                javax.script.ScriptEngine engine = mgr.getEngineByName("JavaScript");
                return engine.eval(expression).toString(); // Evaluate and return the result as string
            } catch (Exception e) {
                return "Error"; // Return error if the expression is invalid
            }
        }
    }

    // Main method to launch the calculator
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the calculator GUI
            GUICalculator calculator = new GUICalculator();
            calculator.setResizable(true); // Allow the window to be resized
        });
    }
}

