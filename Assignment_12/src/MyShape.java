
import java.awt.Color;
import java.awt.Graphics;

abstract class MyShape {
    protected int x1, y1, x2, y2;
    protected Color color;
    protected boolean filled;

    public MyShape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.filled = filled;
    }

    public abstract void draw(Graphics g);
}

class Line extends MyShape {
    public Line(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
}

class Rectangle extends MyShape {
    public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if (filled) {
            g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        } else {
            g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    }
}

class Circle extends MyShape {
    public Circle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int radius = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (filled) {
            g.fillOval(x1 - radius, y1 - radius, 2 * radius, 2 * radius);
        } else {
            g.drawOval(x1 - radius, y1 - radius, 2 * radius, 2 * radius);
        }
    }
}
