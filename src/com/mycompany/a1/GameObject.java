package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {

    //private Point2D location;
    private double x;
    private double y;
    private int color;
    private GameWorld gw = new GameWorld();
    
    public GameObject() {
    	this.x = randomizeDouble(gw.getMaxWidth());
    	this.y = randomizeDouble(gw.getMaxHeight());
    }
    
    /**
     * Set this GameObject's x coord
     * @param newColor
     */
    public void setX(double x) { this.x = x; }

    /**
     * Set this GameObject's y coord
     * @param newColor
     */
    public void setY(double y) { this.y = y; }

    /**
     * Get this GameObject's y coord
     * @param newColor
     */
    public double getY() { return y; }

    /**
     * Get this GameObject's x coord
     * @param newColor
     */
    public double getX() { return x; }

    /**
     * Get this GameObject's color
     * @return color
     */
    public int getColor() { return this.color; }
    
    public String getColorString() {
    	String color = "[" + ColorUtil.red(this.color) + "," + ColorUtil.green(this.color) + "," + ColorUtil.blue(this.color) + "]"; 
    	return color;
    }

    /**
     * Set this GameObject's color
     * @param newColor
     */
    public void setColor(int newColor) { this.color = newColor; }
    
    /**
     * Random double in bound
     * @param num
     * @return
     */
    public static double randomizeDouble(int num) {
    	Random rng = new Random();
    	return (double) rng.nextInt(num);
    }
}
