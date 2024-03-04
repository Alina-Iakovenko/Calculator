package com.shpp.p2p.cs.aiakovenko.assignment11.tree;

import com.shpp.p2p.cs.aiakovenko.assignment11.inputParser.VariableMap;

import java.util.HashMap;
import java.util.List;

/***
 * Class to save a variable as a tree node, check it and set rules for this node
 * This is always a leaf node that's why it hasn't children
 */
public class VariableNode extends Node {
    // String for current node
    String valueString;
    // String for current node with another name to make clearer some methods
    String variable;

    public VariableNode(String variable) {
        this.valueString = variable;
        this.variable = variable;
    }
    public String getVariable() {
        return this.variable;
    }
    /***
     * Getter for node`s value
     * @return      string for this root
     */
    public String getValueString() {
        return valueString;
    }
    /***
     * Getter for node's children
     * @return      left child node
     */
    public List<Node> getChildNodes() {
        return childNodes;
    }

    /***
     * Checks if string meets variable's rules (consists only letters)
     * @param variable      string to check if it's a variable
     * @return              true if it is
     * @throws IllegalArgumentException     if string consists anything else except letters
     */
    public static boolean isValidVariableName(String variable) throws IllegalArgumentException {
        if (!variable.matches("^[a-zA-Z]*")) {
            throw new IllegalArgumentException(": invalid variable name in formula: " + variable);
        }
        return true;
    }

    /***
     * Check if a variable is in a map from arguments
     * @param variables         map with variables and their value
     * @throws IllegalArgumentException     if there is no variables in map
     *                                      or any of them equals to this
     */
    void checkVariableInMap(HashMap<String, Double> variables) throws IllegalArgumentException {
        if (variables == null) {
            throw new IllegalArgumentException(": no data for variable from formula");
        }
        // Get all map's keys and check if any of it is equals to variable name from formula
        if (variables.containsKey(this.variable)) {
             return;
        }
        throw new IllegalArgumentException(": no data for variable from formula");
    }
    /***
     * Get value vor variable from map and returns it as double
     * @return double
     */
    @Override
    public double evaluate() {
        return VariableMap.getVariablesValue(getVariable());
    }
}