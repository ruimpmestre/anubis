/* --------------------------------------------------------------------------------------------------------------------
 * Project: Exercise 1
 * --------------------------------------------------------------------------------------------------------------------
 * Company: AnubisNetworks.
 * --------------------------------------------------------------------------------------------------------------------
 * 
 * This file contains a simple resolution for Exercise 1
 * 
 * -------------------------------------------------------------------------------------------------------------------- 
 * $Id$
 * --------------------------------------------------------------------------------------------------------------------
 */

package pt.com.anubisnetworks.exercise;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	/**
	 * Indicates whether the rule is valid
	 */
	private boolean valid = false;

	/**
	 * Stores the {@link Rule}'s target tasks
	 */
	private int target = -1;

	/**
	 * Stores the {@link Rule}'s declared number of dependents
	 */
	private int intendedDependents = 0;

	/**
	 * Stores the {@link Rule}'s list of dependents
	 */
	private List<Integer> dependents = new ArrayList<Integer>();

	/**
	 * Class constructor
	 * @param line a line from the Project file.
	 */
	public Rule(List<Integer> line) {
		for(int i = 0, n = line.size(); i < n; ++i) {
			int value = line.get(i);
			
			//invalid value
			if( value < 1 ) {
				return;
			}
			
			switch(i) { //different roles according to the position
				case 0: {
					this.target = value;
					break; 
				}
				case 1: {
					this.intendedDependents = value;
					break;
				}
				default: {
					this.dependents.add(value);
				}
			}
		}
		
		this.valid = (this.intendedDependents == this.dependents.size());
	}

	/**
	 * @return the valid status
	 */
	public boolean isValid() {
		return valid;
	}


	/**
	 * @return the target task
	 */
	public int getTarget() {
		return target;
	}


	/**
	 * @return the intended Dependents
	 */
	public int getIntendedDependents() {
		return intendedDependents;
	}


	/**
	 * @return the dependents list
	 */
	public List<Integer> getDependents() {
		return dependents;
	}

}
