/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * Walks Karel to the door of its house, picks it up the
 * newspaper (represented by a beeper), and then returns
 * to its initial position.
 * Pre: Karel is in the upper left corner of the house, facing east.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {
	public void run() {
		walkToNewspaper();
		safelyPickBeeper();
		getToInitialPosition();
	}
	/*
	 * 
	 */
	private void safelyPickBeeper() {
		if(beepersPresent()) {
			pickBeeper();			
		}
	}

	/*
	 * Walks Karel on the corner with a newspaper.
	 * Pre:  Karel is on the 3th ave 4th street corner, facing east.
	 * Post: Karel is on the 6th ave 3rd street corner, facing west.
	 */
	private void walkToNewspaper() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();		
	}

	/*
	 * 	Walks Karel to its initial position.
	 * 	Pre:  Karel is on the 6th ave 3rd street corner.
	 * 	Post: Karel is in the upper left corner of the house, facing east.
	 */
	private void getToInitialPosition() {
		turnAround();
		move();
		turnRight();
		move();
		turnLeft();
		move();
		move();
		turnAround();
	};
}