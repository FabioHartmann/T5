//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Polygon;

public class Triangle {
    private int height = 30;
    private int width = 40;
    private int xPosition = 50;
    private int yPosition = 15;
    private String color = "green";
    private boolean isVisible = false;

    public Triangle() {
    }

    public void makeVisible() {
        this.isVisible = true;
        this.draw();
    }

    public void makeInvisible() {
        this.erase();
        this.isVisible = false;
    }

    public void moveRight() {
        this.moveHorizontal(20);
    }

    public void moveLeft() {
        this.moveHorizontal(-20);
    }

    public void moveUp() {
        this.moveVertical(-20);
    }

    public void moveDown() {
        this.moveVertical(20);
    }

    public void moveHorizontal(int distance) {
        this.erase();
        this.xPosition += distance;
        this.draw();
    }

    public void moveVertical(int distance) {
        this.erase();
        this.yPosition += distance;
        this.draw();
    }

    public void slowMoveHorizontal(int distance) {
        byte delta;
        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; ++i) {
            this.xPosition += delta;
            this.draw();
        }

    }

    public void slowMoveVertical(int distance) {
        byte delta;
        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; ++i) {
            this.yPosition += delta;
            this.draw();
        }

    }

    public void changeSize(int newHeight, int newWidth) {
        this.erase();
        this.height = newHeight;
        this.width = newWidth;
        this.draw();
    }

    public void changeColor(String newColor) {
        this.color = newColor;
        this.draw();
    }

    private void draw() {
        if (this.isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = new int[]{this.xPosition, this.xPosition + this.width / 2, this.xPosition - this.width / 2};
            int[] ypoints = new int[]{this.yPosition, this.yPosition + this.height, this.yPosition + this.height};
            canvas.draw(this, this.color, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }

    }

    private void erase() {
        if (this.isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }

    }
}
