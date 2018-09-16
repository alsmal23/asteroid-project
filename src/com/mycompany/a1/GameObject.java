package com.mycompany.a1;

import com.codename1.ui.geom.Point2D;

public abstract class GameObject {

    //private Point2D location;
    private float x;
    private float y;
    private int color;

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    /**
     * Get this GameObject's color
     * @return color
     */
    public int getColor() { return this.color; }

    /**
     * Set this GameObject's color
     * @param newColor
     */
    public void setColor(int newColor) { this.color = newColor; }
}
