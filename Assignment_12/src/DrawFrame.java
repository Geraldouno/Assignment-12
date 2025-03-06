import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawFrame extends JFrame {
    private DrawPanel drawPanel;
    private JLabel statusLabel;
    
    public DrawFrame() {
        setTitle("Interactive Drawing Application");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        statusLabel = new JLabel("Mouse at: (0, 0)");
        drawPanel = new DrawPanel(statusLabel);
        
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JButton undoButton = new JButton("Undo Last");
        JButton clearButton = new JButton("Clear All");
        JComboBox<Color> colorComboBox = new JComboBox<>(new Color[] {
            Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE
        });
        JComboBox<String> shapeComboBox = new JComboBox<>(new String[] {"Line", "Circle", "Rectangle"});
        JCheckBox fillCheckBox = new JCheckBox("Filled");

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.clearLastShape();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.clearDrawing();
            }
        });

        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setCurrentColor((Color) colorComboBox.getSelectedItem());
            }
        });

        shapeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int shapeType = shapeComboBox.getSelectedIndex();
                drawPanel.setShapeType(shapeType);
            }
        });

        fillCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setFilledShape(fillCheckBox.isSelected());
            }
        });

        controlPanel.add(undoButton);
        controlPanel.add(clearButton);
        controlPanel.add(colorComboBox);
        controlPanel.add(shapeComboBox);
        controlPanel.add(fillCheckBox);

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawFrame().setVisible(true);
            }
        });
    }
}

