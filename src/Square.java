//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Rectangle;

public class Square {
    private int size = 30;
    private int xPosition = 60;
    private int yPosition = 50;
    private String color = "red";
    private boolean isVisible = false;

    public Square() {
    }

    public void makeVisible() {
        this.isVisible = true;
        this.draw();
    }

    public void makeInvisible() {
        this.erase();
        this.isVisible = false;
    }

    public String getColor() {
        return this.color;
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

    public void reset(){
         xPosition = 60;
         yPosition = 50;
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

    public void changeSize(int newSize) {
        this.erase();
        this.size = newSize;
        this.draw();
    }

    public void changeColor(String newColor) {
        this.color = newColor;
        this.draw();
    }

    private void draw() {
        if (this.isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, this.color, new Rectangle(this.xPosition, this.yPosition, this.size, this.size));
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
