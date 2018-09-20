package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a1.exceptions.IllegalFixedObjectMethod;

public abstract class GameObject {

    private Point2D location;
	private int color;
    private GameWorld gw = new GameWorld();
    
    public GameObject() {
    	this.location = new Point2D(randomizeDouble(gw.getMaxWidth()), randomizeDouble(gw.getMaxHeight()));
    }
    
    /**
   	 * @return the location
   	 */
   	public Point2D getLocation() {
   		return location;
   	}

   	/**
   	 * @param location the location to set
   	 * @throws IllegalFixedObjectMethod 
   	 */
   	public void setLocation(Point2D location) {
   		this.location = location;
   	}

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
    
    public int randomizeIntRange(int lowerBound, int upperBound) {
    	Random rng = new Random();
    	if (lowerBound == 0) 
    		return rng.nextInt(upperBound);
    	else
    		return rng.nextInt(upperBound - lowerBound) + lowerBound;
    }
    
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
