package com.mycompany.a1;

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
	
	/**
	 * Cannot set x coord of a fixed object
	 * @param x
	 * @throws IllegalFixedObjectMethod
	 */
	public void setX(int x) throws IllegalFixedObjectMethod {
		throw new IllegalFixedObjectMethod("Cannot Set X coord for a Fixed Object");
	}

	/**
	 * Cannot set y coord of a fixed object
	 * @param y
	 * @throws IllegalFixedObjectMethod
	 */
	public void setY(int y) throws IllegalFixedObjectMethod {
		throw new IllegalFixedObjectMethod("Cannot Set Y coord for a Fixed Object");
	}
}
