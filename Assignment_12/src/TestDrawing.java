import javax.swing.*;

public class TestDrawing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DrawFrame frame = new DrawFrame();
                frame.setVisible(true);
            }
        });
    }
}
