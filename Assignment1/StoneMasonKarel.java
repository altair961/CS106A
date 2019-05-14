/*
 * File: StoneMasonKarel.java
 * --------------------------
 * Makes Karel repair columns filling gaps with beepers regardless
 * of world's size and columns height. The columns might be of the
 * different height as well.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run() {
		while (frontIsClear()) {
			fixColumn();
			moveToNextColumn();
		}
		fixColumn();
	}
	
	/*
	 * 	Makes Karel fix the column of arbitrary height and then back
	 *  down to its original position.
	 * 	Pre:  Karel is on the 1st, 5th, 9th, 13th etc ave and 1st street corner facing east.
	 * 	Post: Karel is on the 1st row of the column it just fixed
	 */	
	private void fixColumn() {
		turnLeft();
		fillInColumnGaps();
		turnAround();
		descendColumn();
	}

	/*
	 * 	Makes Karel fix the column of arbitrary height.
	 * 	Pre:  Karel is on the 1st, 5th, 9th, 13th etc ave and 1st street corner facing east.
	 * 	Post: Karel is on the last row of the column it just fixed facing north.
	 */	
	private void fillInColumnGaps() {
		while (frontIsClear()) {
			if(noBeepersPresent()) {
				putBeeper();
			}
			move();
		}
		if(noBeepersPresent()) {
			putBeeper();
		}
	}
	
	/*
	 * Moves Karel down the column.
	 * Pre:  Karel is on the last row of the column it just fixed facing south.
	 * Post: Karel is on the first row of the column it just fixed facing east.
	 */
	private void descendColumn() {
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
	
	/*
	 * Walks Karel to the next column at 1st, 5th, 9th, 13th etc ave 
	 * Pre:  Karel is on the first row of a column at 1st, 5th, 9th, 13th etc ave facing east.
	 * Post: Karel is on the first row of a column at 1st, 5th, 9th, 13th etc ave facing east.
	 */
	private void moveToNextColumn() {
		for (int i = 0; i <= 3; i++) {
			if(frontIsClear()) {
				move();
			}
		}
	}
}