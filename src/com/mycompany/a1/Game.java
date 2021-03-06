package com.mycompany.a1;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener; import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent; import java.lang.String;


/**
 * Game --- class that acts as the controller for the Asteroids game
 * @author Alexandria Smallwood
 */
public class Game extends Form {

    private GameWorld gameWorld;

    /**
     * Constructor for the class Game
     * Initializes the gameWorld
     */
    public Game() {
        gameWorld = new GameWorld();
        gameWorld.init();
        play();
    }

    /**
     * Method that accepts and computes commands given by the user
     */
    private void play() {
    	Label myLabel=new Label("Enter a Command:"); this.addComponent(myLabel);
    	final TextField myTextField=new TextField(); this.addComponent(myTextField);
    	this.show();
    	myTextField.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent evt) {
    			String sCommand=myTextField.getText().toString(); myTextField.clear();
    			switch (sCommand.charAt(0)) { 
    				case 'a':
    					gameWorld.addAsteroid();
    					break;
    					
    				case 'y':
    					gameWorld.addNPS();
    					break;
    					
    				case 'b':
    					gameWorld.addSpaceStation();
    					break;
    					
    				case 's':
    					gameWorld.addPS();
    					break;
    					
    				case 'i':
    					gameWorld.increasePSSpeed();
    					break;
    					
    				case 'd':
    					gameWorld.decreasePSSpeed();
    					break;
    					
    				case 'l':
    					gameWorld.turnPSLeft();
    					break;
    					
    				case 'r':
    					gameWorld.turnPSRight();
    					break;
    					
    				case '<':
    					gameWorld.turnPSLauncher();
    					break;
    				
    				case 'f':
    					gameWorld.fireMissile();
    					break;
    				
    				case 'L':
    					gameWorld.launchMissileNPS();
    					break;
    					
    				case 'j':
    					gameWorld.hyperspace(); // test after move is implemented
    					break;
    					
    				case 'n':
    					gameWorld.reloadPS();
    					break;
    					
    				case 'k':
    					gameWorld.killAsteroid();
    					break;
    					
    				case 'e':
    					gameWorld.eliminateNPS();
    					break;
    				
    				case 'E':
    					gameWorld.explodePS();
    					break;
    					
    				case 'c':
    					gameWorld.crashedPS();
    					break;
    				
    				case 'h':
    					gameWorld.psHitsNPS();
    					break;
    				
    				case 'x':
    					gameWorld.exterminationOfAsteroids();
    					break;
    				
    				case 'I':
    					gameWorld.asteroidCollidedWithNPS();
    					break;
    				
    				case 't':
    					gameWorld.timeTick();
    					break;
    				
    				case 'p':
    					gameWorld.printGameStatus();
    					break;
    					
    				case 'm':
    					gameWorld.printMap();
    					break;
    				
    				case 'q':
    					boolean quit = Dialog.show("Confirm quit", "Are you sure you want to quit?", "Okay", "Cancel");
    					if (quit) {
    						Display.getInstance().exitApplication();
    					}
    					break;
    					
    				default:
    					System.out.println("Invalid cmd please try again");
    					break;
    					
    			
    			} //switch
    		} //actionPerformed
    	}); //addActionListener
    }
}

