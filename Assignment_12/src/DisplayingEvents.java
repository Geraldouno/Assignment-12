import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
public class DisplayingEvents {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Displaying Application Events ");
        JButton actionButton = new JButton("Click Me");
        JCheckBox checkBox = new JCheckBox("Check Me");
        JTextField textField = new JTextField(20);
        JList<String> list = new JList<>(new String[]{"Item 1", "Item 2", "Item 3"});
        JLabel eventLabel = new JLabel("The Event messages will appear here");

        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventLabel.setText("ActionEvent: " + e.toString());
            }
        });

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                eventLabel.setText("ItemEvent: " + e.toString());
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                eventLabel.setText("ListSelectionEvent: " + e.toString());
            }
        });

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventLabel.setText("MouseEvent (Clicked): " + e.toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                eventLabel.setText("MouseEvent (Pressed): " + e.toString());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                eventLabel.setText("MouseEvent (Released): " + e.toString());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                eventLabel.setText("MouseEvent (Entered): " + e.toString());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                eventLabel.setText("MouseEvent (Exited): " + e.toString());
            }
        });

        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                eventLabel.setText("MouseMotionEvent (Dragged): " + e.toString());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                eventLabel.setText("MouseMotionEvent (Moved): " + e.toString());
            }
        });

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                eventLabel.setText("KeyEvent (Typed): " + e.toString());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                eventLabel.setText("KeyEvent (Pressed): " + e.toString());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                eventLabel.setText("KeyEvent (Released): " + e.toString());
            }
        });
        
        frame.add(actionButton);
        frame.add(checkBox);
        frame.add(textField);
        frame.add(new JScrollPane(list)); 
        frame.add(eventLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}

