package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;


public class NonPlayerShip extends Ship {
	
	private int size;
	
	public NonPlayerShip() {
		int temp = this.randomizeIntRange(0, 2);
		if (temp == 0) 
			this.size = 10;
		else if (temp == 1)
			this.size = 20;
		this.setColor(ColorUtil.YELLOW);
	}

    @Override
    public void move() {

    }

    @Override
    public Missile fireMissile() {
    	return new Missile();
    }
    
    @Override
    public String toString() {
    	return "Non-Player Ship: loc=" + this.getLocation() + " color=" + this.getColorString() + " speed=" + this.getSpeed() 
    		+ " dir=" + this.getDirection() + " size=" + this.size;
    }
}
