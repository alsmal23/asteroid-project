package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.codename1.ui.geom.Point2D;

public class GameWorld {


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
     * Print current game status
     * cmd: p
     */
    
    public void printGameStatus() {
    	int missiles = 0;
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof PlayerShip) {
    			PlayerShip temp = (PlayerShip) gameObjects.get(i);
    			missiles = temp.getMissileCount();
    		}
    	}
    	System.out.println("Current Game Status: \nScore: " + this.getScore() + "\nMissiles Left: " +  missiles + "\nGame Clock: " + this.getClock()
    			+ "\nHearts: " + this.getHearts());
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
    	boolean missile = false;
    	
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof NonPlayerShip && !found) {
    			NonPlayerShip temp = (NonPlayerShip) gameObjects.get(i);
    			if (temp.hasMissiles()) {
    				gameObjects.add(temp.fireMissile());
    				missile = true;
    			}
    				
    			found = true;
    		}
    	}
    	
    	if (found && missile) {
    		System.out.println("Non Player Ship fired missile");
    	} else if (!missile && found)
    		missingInGame("missiles"); // should probably throw exception
    	else 
    		missingInGame("N2PS");
    	
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
    		if (asteroid > missile) {
        		gameObjects.remove(asteroid);
        		gameObjects.remove(missile);
    		} else {
        		gameObjects.remove(missile);
        		gameObjects.remove(asteroid);
    		}
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
    		if (gameObjects.get(i) instanceof PSMissile)
    			missile = i;
    		if (gameObjects.get(i) instanceof NonPlayerShip && !found) {
    			nps = i;
    			found = true;
    		}
    	}
    	
    	if (found && missile != -1) {
    		if (missile > nps) {
        		gameObjects.remove(missile);
        		gameObjects.remove(nps);
    		} else {
        		gameObjects.remove(nps);
        		gameObjects.remove(missile);
    		}
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
    		if (gameObjects.get(i) instanceof NPSMissile)
    			missile = i;
    		if (gameObjects.get(i) instanceof PlayerShip && !found) {
    			PlayerShip temp = (PlayerShip) gameObjects.get(i);
    			if (hasHeartsToSpare()) { // fix... don't remember what to fix lool
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
    		if (missile > ps) {
        		gameObjects.remove(missile);
        		gameObjects.remove(ps);
    		} else {
        		gameObjects.remove(ps);
        		gameObjects.remove(missile);
    		}
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
    		if (asteroid > ps) {
        		gameObjects.remove(asteroid);
        		gameObjects.remove(ps);
    		} else {
        		gameObjects.remove(ps);
        		gameObjects.remove(asteroid);
    		}
    		psExists = false;
    		System.out.println("PS crashed into an asteroid and was destroyed"); // should probably throw exception
    	} else if (!found) 
    		missingInGame("PS");
    	else
    		missingInGame("missile");
    	
    	found = false; // reset found boolean
    }
    
    /**
     * Ps has hit a NPS
     * cmd: h
     */
    
    public void psHitsNPS() {
    	int nps = -1;
    	int ps = -1;
    	boolean gameOver = false;
    	
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof NonPlayerShip)
    			nps = i;
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
    	else if (found && nps != -1 && ps != -1) {
    		gameObjects.remove(nps);
    		System.out.println("PS hit a NPS and the NPS was destroyed"); // should probably throw exception
    	} else if (!found) 
    		missingInGame("PS");
    	else
    		missingInGame("NPS");
    	
    	found = false; // reset found boolean
    }
    
    /**
     * Two asteroids have collided
     * cmd: x
     */
    public void exterminationOfAsteroids() {
    	int asteroid1 = -1;
    	int asteroid2 = -1;
    	
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof Asteroid) {
    			if (asteroid1 == -1)
    				asteroid1 = i;
    			else if (asteroid2 == -1)
    				asteroid2 = i;
    				
    		}

    	}
    	
    	if (asteroid1 != -1 && asteroid2 != -1) {
    		gameObjects.remove(asteroid1);
    		gameObjects.remove(asteroid2 - 1);
    		System.out.println("Two asteroids have collided and been destroyed"); // should probably throw exception
    	} else
    		missingInGame("asteroid");

    }
    
    /**
     * NPS and asteroid collided and destroyed each other
     * cmd: I
     */
    public void asteroidCollidedWithNPS() {
    	int asteroid = -1;
    	int nps = -1;
    	
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof Asteroid && asteroid == -1)
    			asteroid = i;
    		else if (gameObjects.get(i) instanceof NonPlayerShip && nps == -1)
    			nps = i;

    	}
    	
    	if (asteroid != -1 && nps != -1) {
    		if (asteroid > nps) {
        		gameObjects.remove(asteroid);
        		gameObjects.remove(nps);
    		} else {
        		gameObjects.remove(nps);
        		gameObjects.remove(asteroid);
    		}
    		System.out.println("An asteroid has collided with a NPS"); // should probably throw exception
    	} else if (asteroid == -1)
    		missingInGame("asteroid");
    	else
    		missingInGame("NPS");
    }
    
    /**
     * Time ticked, the game must go on
     * cmd: t
     */
    public void timeTick() {
    	for (int i = 0; i < gameObjects.size(); i++) {
    		if (gameObjects.get(i) instanceof MoveableObject) {
    			MoveableObject temp = (MoveableObject) gameObjects.get(i);
    			if (temp instanceof Missile) {
    				Missile missileT = (Missile) temp;
    				if (missileT.isFuelEmpty())
    					gameObjects.remove(i);
    			}
    			temp.move();
    			found = true;
    		}
    	}
    	
    	if (found) 
    		System.out.println("Moved moveable objects");
    	else
    		System.out.println("No moveable objects");
    	
    	found = false;
    	clock++;
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
    public int getHearts() { return hearts; }


    private static void missingInGame(String missingObject) {
    	System.out.println("No " + missingObject + " in game");
    }
	
}

