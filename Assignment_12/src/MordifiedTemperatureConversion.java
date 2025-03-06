import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    
public class MordifiedTemperatureConversion {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Conversion");
        JLabel inputLabel = new JLabel("Enter temperature:");
        JTextField inputTextField = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Converted temperature: ");
        
        String[] scales = {"Fahrenheit", "Celsius", "Kelvin"};
        JComboBox<String> fromScaleComboBox = new JComboBox<>(scales);
        JComboBox<String> toScaleComboBox = new JComboBox<>(scales);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the input temperature and the selected scales
                    double inputTemp = Double.parseDouble(inputTextField.getText());
                    String fromScale = (String) fromScaleComboBox.getSelectedItem();
                    String toScale = (String) toScaleComboBox.getSelectedItem();

                    double tempResult = 0.0;

                    if (fromScale.equals("Fahrenheit")) {
                        if (toScale.equals("Celsius")) {
                            tempResult = (inputTemp - 32) * 5.0 / 9.0;
                        } else if (toScale.equals("Kelvin")) {
                            tempResult = (inputTemp - 32) * 5.0 / 9.0 + 273.15;
                        } else {
                            tempResult = inputTemp;
                        }
                    } else if (fromScale.equals("Celsius")) {
                        if (toScale.equals("Fahrenheit")) {
                            tempResult = inputTemp * 9.0 / 5.0 + 32;
                        } else if (toScale.equals("Kelvin")) {
                            tempResult = inputTemp + 273.15;
                        } else {
                            tempResult = inputTemp;
                        }
                    } else if (fromScale.equals("Kelvin")) {
                        if (toScale.equals("Fahrenheit")) {
                            tempResult = (inputTemp - 273.15) * 9.0 / 5.0 + 32;
                        } else if (toScale.equals("Celsius")) {
                            tempResult = inputTemp - 273.15;
                        } else {
                            tempResult = inputTemp;
                        }
                    }

                    resultLabel.setText("Converted temperature: " + String.format("%.2f", tempResult) + " " + toScale);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        frame.add(inputLabel);
        frame.add(inputTextField);
        frame.add(new JLabel("From Scale:"));
        frame.add(fromScaleComboBox);
        frame.add(new JLabel("To Scale:"));
        frame.add(toScaleComboBox);
        frame.add(convertButton);
        frame.add(resultLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
