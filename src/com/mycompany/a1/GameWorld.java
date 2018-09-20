package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.codename1.ui.geom.Point2D;

public class GameWorld {

    private static final int MAX_WIDTH = 1024;
    private static final int MAX_HEIGHT = 768;
    private static boolean psExists = false;
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private int clock;
    private int score;
    private int hearts;
    private static final int MAX_HEARTS = 3;
    private boolean found = false;

    public GameWorld() {
    	this.init();
    }

    /**
     * Initialize game objects and setup the game
     */
    public void init() {
    	score = 0;
    	clock = 0;
    	hearts = MAX_HEARTS;
    }
    
    /**
     * Add a player ship to the game only if one does not already exist
     * cmd: s
     */
    public void addPS() {
    	if (!psExists) {
    		gameObjects.add(new PlayerShip());
    		psExists = true;
        	System.out.println("Added Player Ship");
    	} else
    		System.out.println("Player Ship already in game"); // should delete
    }
    
    /**
     * Add NPS to the game world
     * cmd: y
     */
    public void addNPS() {
    	gameObjects.add(new NonPlayerShip());
    	System.out.println("Added Non Player Ship");
    }
    
    /**
     * Add an asteroid to the game world
     * cmd: a
     */
    public void addAsteroid() {
    	gameObjects.add(new Asteroid());
    	System.out.println("Added Asteroid");
    }
    
    /**
     * Add Space Station
     * cmd: b
     */
    public void addSpaceStation() {
    	gameObjects.add(new SpaceStation());
    	System.out.println("Added Space Station");
    }
    
    /**
     * Print the map of the game world
     * cmd: m
     */
    public void printMap() {
    	for (int i = 0; i < gameObjects.size(); i++) {
    		System.out.println(gameObjects.get(i).toString());
    	}
    }
    
    /**
     * Fire missile from PS ship
     * cmd: f
     */
    public void fireMissile() {
    	boolean missile = false;
    	
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof PlayerShip && !found) {
    			PlayerShip temp = (PlayerShip) gameObjects.get(i);
    			if (temp.hasMissiles()) {
    				gameObjects.add(temp.fireMissile());
    				missile = true;
    			}
    				
    			gameObjects.set(i, temp);
    			found = true;
    		}
    	}
    	
    	if (found && missile) {
    		System.out.println("Player Ship fired missile");
    	} else if (!missile && found)
    		missingInGame("missiles"); // should probably throw exception
    	else 
    		missingInGame("PS");
    	
    	found = false; // reset found boolean
    }
    
    /**
     * Fire missile from NPS
     * cmd: L
     */
    public void launchMissileNPS() {
    	
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof NonPlayerShip && !found) {
    			NonPlayerShip temp = (NonPlayerShip) gameObjects.get(i);
    			gameObjects.add(temp.fireMissile());
    			found = true;
    		}
    	}
    	
    	if (found) {
    		System.out.println("Non Player Ship fired missile");
    	} else  
    		missingInGame("NPS");
    	
    	found = false; // reset found boolean
    }
    
    /**
     * Increase the Player ship speed
     * cmd: i
     */
    public void increasePSSpeed() {
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof PlayerShip && !found) {
    			PlayerShip temp = (PlayerShip) gameObjects.get(i);
    			temp.increaseSpeed();
    			gameObjects.set(i, temp);
    			found = true;
    		}
    	}
    	
    	if (found) {
    		System.out.println("Increased Player Ship speed");
    	} else
    		missingInGame("PS"); // should probably throw exception
    	
    	found = false; // reset found boolean
    }
    
    /**
     * Decrease the Player ship speed
     * cmd: d
     */
    public void decreasePSSpeed() {
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof PlayerShip && !found) {
    			PlayerShip temp = (PlayerShip) gameObjects.get(i);
    			temp.decreaseSpeed();
    			gameObjects.set(i, temp);
    			found = true;
    		}
    	}
    	
    	if (found) {
    		System.out.println("Decreased Player Ship speed");
    	} else
    		missingInGame("PS"); // should probably throw exception
    	
    	found = false; // reset found boolean
    }
    
    /**
     * Steer player ship to the left
     * cmd: l
     */
    public void turnPSLeft() {
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof PlayerShip && !found) {
    			PlayerShip temp = (PlayerShip) gameObjects.get(i);
    			temp.steerLeft();
    			gameObjects.set(i, temp);
    			found = true;
    		}
    	}
    	
    	if (found) {
    		System.out.println("Turned Player Ship left");
    	} else
    		missingInGame("PS"); // should probably throw exception
    	
    	found = false; // reset found boolean
    }
    
    /**
     * Steer player ship to the right
     * cmd: r
     */
    public void turnPSRight() {
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof PlayerShip && !found) {
    			PlayerShip temp = (PlayerShip) gameObjects.get(i);
    			temp.steerRight();
    			gameObjects.set(i, temp);
    			found = true;
    		}
    	}
    	
    	if (found) {
    		System.out.println("Turned Player Ship right");
    	} else
    		missingInGame("PS"); // should probably throw exception
    	
    	found = false; // reset found boolean
    }
    
    /**
     * Steer player ship's launcher
     * cmd: <
     */
    public void turnPSLauncher() {
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof PlayerShip && !found) {
    			PlayerShip temp = (PlayerShip) gameObjects.get(i);
    			temp.steerMissileLauncher();
    			gameObjects.set(i, temp);
    			found = true;
    		}
    	}
    	
    	if (found) {
    		System.out.println("Turned Player Ship's launcher");
    	} else
    		missingInGame("PS"); // should probably throw exception
    	
    	found = false; // reset found boolean
    }
    
    /**
     * Jump through hyperspace
     * cmd: j
     */
    public void hyperspace() {
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof PlayerShip && !found) {
    			PlayerShip temp = (PlayerShip) gameObjects.get(i);
    			temp.resetLocation();
    			gameObjects.set(i, temp);
    			found = true;
    		}
    	}
    	
    	if (found) {
    		System.out.println("Player Ship jumped through hyperspace");
    	} else
    		System.out.println("No Player Ship to jump through hyperspace"); // should probably throw exception
    	
    	found = false; // reset found boolean
    }
    
    /**
     * Reload Player Ship with missiles from a space station
     * cmd: n
     */
    public void reloadPS() {
    	boolean station = false;
    	int ps = -1;
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if(gameObjects.get(i) instanceof SpaceStation)
    			station = true;
    		
    		if (gameObjects.get(i) instanceof PlayerShip && !found) {
    			ps = i;
    			found = true;
    		}
    	}
    	
    	if (found && station) {
    		PlayerShip temp = (PlayerShip) gameObjects.get(ps);
			temp.reloadMissiles();
			gameObjects.set(ps, temp);
    		System.out.println("Player Ship reloaded to maximum amount of missiles");
    	} else
    		System.out.println("No Player Ship to reload missiles into or missing space station"); // should probably throw exception
    	
    	found = false; // reset found boolean
    }
    
    /**
     * PS has struck an asteroid with a missile to eliminate it
     * cmd: k
     */
    public void killAsteroid() {
    	int missile = -1;
    	int asteroid = -1;
    	addToScore(4);
    	
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof Missile)
    			missile = i;
    		if (gameObjects.get(i) instanceof Asteroid && !found) {
    			asteroid = i;
    			found = true;
    		}
    	}
    	
    	if (found && missile != -1) {
    		gameObjects.remove(asteroid);
    		gameObjects.remove(missile - 1);
    		System.out.println("Destroyed Asteroid");
    	} else if (!found && missile != -1)
    		 missingInGame("Asteroid"); // should probably throw exception
    	else 
    		missingInGame("missile");
    	
    	found = false; // reset found boolean
    	
    }
    
   /**
    * PS has struck a NPS with a missile to eliminate it
    * Add 10 Points to the score
    * cmd: e
    */
    public void eliminateNPS() {

    	int missile = -1;
    	int nps = -1;
    	addToScore(10); // add to score for killing a nps
    	
    	//check for PS and/or PS missile
    	//eliminates first nps
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof Missile)
    			missile = i;
    		if (gameObjects.get(i) instanceof NonPlayerShip && !found) {
    			nps = i;
    			found = true;
    		}
    	}
    	
    	if (found && missile != -1) {
    		gameObjects.remove(nps);
    		gameObjects.remove(missile - 1);
    		System.out.println("Destroyed NPS");
    	} else if (found && missile == -1)
    		 missingInGame("missile"); // should probably throw exception
    	else 
    		missingInGame("NPS");
    	
    	found = false; // reset found boolean
    }
    
    /**
     * NPS's missile hit PS 
     * cmd: E
     */
    public void explodePS() {
    	int missile = -1;
    	int ps = -1;
    	boolean gameOver = false;
    	
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof Missile)
    			missile = i;
    		if (gameObjects.get(i) instanceof PlayerShip && !found) {
    			PlayerShip temp = (PlayerShip) gameObjects.get(i);
    			if (hasHeartsToSpare()) { // fix
    				ps = i;
    				removeHeart();
    			} else {
    				// game over
    				gameOver = true;
    			}
    			found = true;
    		}
    	}
    	
    	if (gameOver)
    		System.out.println("Game Over");
    	else if (found && missile != -1 && ps != -1) {
    		gameObjects.remove(ps);
    		gameObjects.remove(missile - 1);
    		psExists = false;
    		System.out.println("PS was destroyed by NPS missile"); // should probably throw exception
    	} else if (!found) 
    		missingInGame("PS");
    	else
    		missingInGame("missile");
    	
    	found = false; // reset found boolean	
    }
    
    /**
     * PS has crashed into an Asteroid
     * cmd: c
     */
    public void crashedPS() {
    	int asteroid = -1;
    	int ps = -1;
    	boolean gameOver = false;
    	
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof Asteroid)
    			asteroid = i;
    		if (gameObjects.get(i) instanceof PlayerShip && !found) {
    			PlayerShip temp = (PlayerShip) gameObjects.get(i);
    			if (hasHeartsToSpare()) { // fix
    				ps = i;
    				removeHeart();
    			} else {
    				// game over
    				gameOver = true;
    			}
    			found = true;
    		}
    	}
    	
    	if (gameOver)
    		System.out.println("Game Over");
    	else if (found && asteroid != -1 && ps != -1) {
    		gameObjects.remove(ps);
    		gameObjects.remove(asteroid - 1);
    		psExists = false;
    		System.out.println("PS was destroyed by NPS missile"); // should probably throw exception
    	} else if (!found) 
    		missingInGame("PS");
    	else
    		missingInGame("missile");
    	
    	found = false; // reset found boolean
    }

    /**
     * Add points to overall score of the game
     */
    private void addToScore(int points) { score += points; }
    
    private boolean hasHeartsToSpare() {
    	if (this.hearts == 0)
    		return false;
    	else
    		return true;
    }
    
    private void removeHeart() { this.hearts--; }
    
    public int getClock() { return clock; }
    public int getScore() { return score; }
    public int getMaxWidth() { return MAX_WIDTH; }
    public int getMaxHeight() { return MAX_HEIGHT; }
    

    private static void missingInGame(String missingObject) {
    	System.out.println("No " + missingObject + " in game");
    }
	
}

