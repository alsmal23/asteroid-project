package com.mycompany.a1;

import com.codename1.ui.geom.Point2D;
import com.mycompany.a1.exceptions.IllegalFixedObjectMethod;

public abstract class FixedObject extends GameObject{
	
	private int id;
	private static int nextId = 0;
	
	public FixedObject() {
		id = nextId;
		nextId++;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	@Override
	public void setLocation(Point2D location) {
		//throw new IllegalFixedObjectMethod("Cannot Set Location for a Fixed Object");
		System.out.println("Cannot change location of FixedObject");
	}
	
}
