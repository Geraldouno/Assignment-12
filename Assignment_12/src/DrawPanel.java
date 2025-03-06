import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel {
    private MyShape[] shapes;
    private int shapeCount;
    private int shapeType;
    private MyShape currentShape;
    private Color currentColor;
    private boolean filledShape;
    private JLabel labelState;

    public DrawPanel(JLabel labelState) {
        this.shapes = new MyShape[100];
        this.shapeCount = 0;
        this.shapeType = 0; 
        this.currentShape = null;
        this.currentColor = Color.BLACK;
        this.filledShape = false;
        this.labelState = labelState;
        this.setBackground(Color.WHITE);
        
        MouseHandler handler = new MouseHandler();
        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < shapeCount; i++) {
            shapes[i].draw(g);
        }

        if (currentShape != null) {
            currentShape.draw(g);
        }
    }

    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public void setFilledShape(boolean filledShape) {
        this.filledShape = filledShape;
    }

    public void clearLastShape() {
        if (shapeCount > 0) {
            shapeCount--;
            repaint();
        }
    }

    public void clearDrawing() {
        shapeCount = 0;
        repaint();
    }

    private class MouseHandler extends MouseAdapter implements MouseMotionListener {
        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            switch (shapeType) {
                case 0: currentShape = new Line(x, y, x, y, currentColor, filledShape); break;
                case 1: currentShape = new Rectangle(x, y, x, y, currentColor, filledShape); break;
                case 2: currentShape = new Circle(x, y, x, y, currentColor, filledShape); break;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (currentShape != null) {
                currentShape = currentShape;
                shapes[shapeCount] = currentShape;
                shapeCount++;
                currentShape = null;
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            labelState.setText("Mouse at: (" + e.getX() + ", " + e.getY() + ")");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (currentShape != null) {
                currentShape.x2 = e.getX();
                currentShape.y2 = e.getY();
                repaint();
            }
        }
    }
}

