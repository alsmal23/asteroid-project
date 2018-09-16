package com.mycompany.a1;

import java.util.ArrayList;

public class GameWorld {

    private static final int MAX_WIDTH = 1024;
    private static final int MAX_HEIGHT = 768;
    private static boolean psExists;
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private int clock;
    private int score;

    public GameWorld() {
    	this.init();
    }

    /**
     * Initialize game objects and setup the game
     */
    public void init() {
    	score = 0;
    	clock = 0;
    	psExists = false;
    }
    
    /**
     * Add a playership to the game only if one does not already exist
     */
    public void addPS() {
    	if (!psExists) {
    		gameObjects.add(new PlayerShip());
    		psExists = true;
    	} else
    		System.out.println("I ALREADY EXIST");
    }
    
    /**
     * Print the map of the game world
     */
    public void printMap() {
    	for (int i = 0; i < gameObjects.size(); i++) {
    		System.out.println(gameObjects.get(i).toString());
    	}
    }
    
    public void fireMissile() {
    	
    }
    
   /**
    * PS has struck a NPS with a missile to eliminate it
    */
    public void eliminateNPS() {
    	// TODO 
    	System.out.println("YE A GONER");
    }

    public void addToScore(int points) { score += points; }
    public int getClock() { return clock; }
    public int getScore() { return score; }
    public int getMaxWidth() { return MAX_WIDTH; }
    public int getMaxHeight() { return MAX_HEIGHT; }

	
}
