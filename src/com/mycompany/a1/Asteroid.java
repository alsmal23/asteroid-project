package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Asteroid extends MoveableObject {
	
	private int size;
	
	public Asteroid() {
		this.setColor(ColorUtil.GRAY);
		this.size = this.randomizeIntRange(6, 31);
	}
	
	@Override
	public String toString() {
		return "Asteroid: loc=" + this.getLocation() + " color=" + this.getColorString() + " speed="
    			+ this.getSpeed() + " dir=" + this.getDirection() + " size=" + this.size;
	}

}
