import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    
public class TemperatureConversion {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Conversion");
        JLabel fahrenheitLabel = new JLabel("Enter Fahrenheit:");
        JTextField fahrenheitTextField = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        JLabel celsiusLabel = new JLabel("Celsius: ");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double fahrenheit = Double.parseDouble(fahrenheitTextField.getText());

                    double celsius = 5.0 / 9.0 * (fahrenheit - 32);

                    celsiusLabel.setText("Celsius: " + String.format("%.2f", celsius));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        frame.add(fahrenheitLabel);
        frame.add(fahrenheitTextField);
        frame.add(convertButton);
        frame.add(celsiusLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        frame.setVisible(true);
    }
}