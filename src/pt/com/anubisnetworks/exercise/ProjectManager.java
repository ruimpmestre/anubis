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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The Exercise class provides a simple solution for Exercise 1
 */
public class ProjectManager {


	/**
	 * The default field separator
	 */
	private static String defaultFieldSeparator = " ";


	/**
	 * Main execution body
	 * 
	 * @param args command line arguments (ignored)
	 */
	public static void main(String[] args)  {

		ProjectDefinition def = new ProjectDefinition();
		
		//iterate input lines
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			String line;
			while( (line = reader.readLine() ) != null ) {
				List<Integer> numbers = new ArrayList<>();
				//parse the several lines' values
			    for (String part: line.split(defaultFieldSeparator)) {
				    //determine the element from the file line
				    int elem = Integer.parseInt(part);

			        numbers.add(elem);
			    }
			    
			    def.parseLine(numbers);
			  
			}
			
			System.out.println(def.processDefinition());
				
		} catch(Exception e) {
			//e.printStackTrace();
			System.err.println("Problem processing input file: " + e.getMessage());
		}	
				
	}
}
