import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectColorGUI extends JFrame {
    private JComboBox<String> colorComboBox; 
    private JButton okButton, cancelButton;
    private JPanel previewPanel; 
    private boolean isBackgroundSelected = true;

    public SelectColorGUI() {
        setTitle("Color Selection");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] colors = {"Red", "Green", "Blue", "Yellow", "Black", "White", "Orange", "Purple"};
        colorComboBox = new JComboBox<>(colors);
        colorComboBox.setSelectedIndex(0); 

        previewPanel = new JPanel();
        previewPanel.setPreferredSize(new Dimension(100, 100));

        JPanel buttonPanel = new JPanel();


        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");


        okButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(SelectColorGUI.this, "You selected: " + selectedColor);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(colorComboBox, BorderLayout.NORTH);
        panel.add(previewPanel, BorderLayout.CENTER);

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                Color color = Color.RED;

                switch (selectedColor) {
                    case "Red":
                        color = Color.RED;
                        break;
                    case "Green":
                        color = Color.GREEN;
                        break;
                    case "Blue":
                        color = Color.BLUE;
                        break;
                    case "Yellow":
                        color = Color.YELLOW;
                        break;
                    case "Black":
                        color = Color.BLACK;
                        break;
                    case "White":
                        color = Color.WHITE;
                        break;
                    case "Orange":
                        color = Color.ORANGE;
                        break;
                    case "Purple":
                        color = Color.MAGENTA;
                        break;
                }

                if (isBackgroundSelected) {
                    previewPanel.setBackground(color);
                } else {
                    previewPanel.setForeground(color);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SelectColorGUI();
            }
        });
    }
}