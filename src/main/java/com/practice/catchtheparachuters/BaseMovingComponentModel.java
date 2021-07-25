package com.practice.catchtheparachuters;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * The model base class of all moving elements
 */

public abstract class BaseMovingComponentModel {

    protected Direction direction = Direction.RIGHT;
    protected int x = 0;
    protected int y = 0;
    protected int w;
    protected int h;
    protected Image image;
    protected int steps = 1;

    public BaseMovingComponentModel(String imagePath) {
        loadImage(imagePath);
    }

    public void loadImage(String imagePath) {

        ImageIcon ii = new ImageIcon(imagePath);
        image = ii.getImage();
        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void incrementX(int value) {
        this.x += value;
    }

    public void decrementX(int value) {
        this.x -= value;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incrementY(int value) {
        this.y += value;
    }

    public void decrementY(int value) {
        this.y -= value;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {

        return h;
    }

    public Image getImage() {

        return image;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
