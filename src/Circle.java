//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.geom.Ellipse2D.Double;

public class Circle {
    private int diameter = 30;
    private int xPosition = 20;
    private int yPosition = 60;
    private String color = "blue";
    private boolean isVisible = false;

    public Circle() {
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

    public String getColor() {
        return color;
    }

    public void reset(){
        xPosition = 20;
        yPosition = 60;
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

    public void changeSize(int newDiameter) {
        this.erase();
        this.diameter = newDiameter;
        this.draw();
    }

    public void changeColor(String newColor) {
        this.color = newColor;
        this.draw();
    }

    private void draw() {
        if (this.isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, this.color, new Double((double)this.xPosition, (double)this.yPosition, (double)this.diameter, (double)this.diameter));
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

