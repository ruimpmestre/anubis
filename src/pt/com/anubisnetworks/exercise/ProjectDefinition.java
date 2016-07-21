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

import java.util.List;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.TopologicalOrderIterator;

import java.util.ArrayList;

/**
 * 
 * @author rmpm
 *
 */
public class ProjectDefinition {

	/**
	 * indicates if the {@link ProjectDefinition} file header has been parsed
	 */
	private boolean initialized;
	
	/**
	 * Stores the number of tasks in the {@link ProjectDefinition}
	 */
	private int nTasks;
	
	/**
	 *Stores the number of rules in the {@link ProjectDefinition}
	 */
	private int nRules;
	
	/**
	 * Stores the list of {@link Rule}
	 */
	private List<Rule> rules;

	/**
	 * Class constructor
	 */
	public ProjectDefinition() {
		initialized = false;
		nTasks = 0;
		nRules = 0;
		rules = new ArrayList<Rule>();
	}
	
	/**
	 * @return the initialized status
	 */
	public boolean isInitialized() {
		return initialized;
	}

	/**
	 * @return the number of tasks
	 */
	public int getnTasks() {
		return nTasks;
	}

	/**
	 * @return the number of Rules
	 */
	public int getnRules() {
		return nRules;
	}

	/**
	 * @return the list of {@link Rule}
	 */
	public List<Rule> getRules() {
		return rules;
	}

	/**
	 * Parses a line from the project definition file
	 * 
	 * @param line the line from the project file
	 */
	public void parseLine(List<Integer> line) {
		if(!isInitialized()) { //process the header
			initialized= true;
			nTasks = line.get(0);
			nRules = line.get(1);
		} else {
			Rule rule = new Rule(line);
			if(rule.isValid()) { 
				//TODO this validity check could be extended to check that a rule does not contain a value above nTasks
				rules.add(rule);
			}
		}
	}
	
	/**
	 * Determines whether the {@link ProjectDefinition}is valid
	 * 
	 * @return boolean, true if valid
	 */
	public boolean isValid() {
		boolean valid = true;
		for(Rule rule:rules) {
			valid = valid && rule.isValid();
			if(!valid) {
				break;
			}
		}
		valid = valid && (nRules == rules.size());
		
		return valid;
	}
	
	/**
	 * Process the {@link ProjectDefinition} to obtain the order by dependencies
	 * 
	 * @return a String with the ordered tasks
	 */
	public String processDefinition() {
		StringBuffer buffer = new StringBuffer();
		if(!isValid()) {
			buffer.append("Invalid project definition!");
		} else {
	 		// constructs a directed graph with the specified vertices and edges
	        DirectedGraph<Integer, DefaultEdge> directedGraph =
	            new DefaultDirectedGraph<Integer, DefaultEdge>(DefaultEdge.class);

	        for(Rule rule: rules) {
        		directedGraph.addVertex(rule.getTarget());
	        	for(Integer dependent: rule.getDependents()) {
	        		directedGraph.addVertex(dependent);
	        		directedGraph.addEdge(dependent, rule.getTarget());
	        	}
	        }

	        //iterates the graph in order
	        TopologicalOrderIterator<Integer, DefaultEdge> it = 
	        		new TopologicalOrderIterator<>(directedGraph);

	        while(it.hasNext()) {
	        	buffer.append(it.next()).append(" ");
	        }

		}	
        return buffer.toString();
	}
	
}
