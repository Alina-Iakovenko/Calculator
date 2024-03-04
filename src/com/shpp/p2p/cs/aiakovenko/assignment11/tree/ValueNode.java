package com.shpp.p2p.cs.aiakovenko.assignment11.tree;

import java.util.List;

/***
 * Class to save a number as a tree node and set rules for this node
 * This is always a leaf node that's why it hasn't children
 */
public class ValueNode extends Node {
    // String for current node
    String valueString;
    // Root parsed in double
    double value;

    public ValueNode(String value) {
        this.valueString = value;
        this.value = Double.parseDouble(value);
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
     * This node just returns its value and calculates anything
     * @return double
     */
    @Override
    public double evaluate() {
        return value;
    }

    // this method is based on this code: https://habr.com/ru/articles/122397/
    /***
     * One more way to check if string can be corresponded in number
     * @param formula   String to check
     * @return          true if it can be a number
     */
    static boolean isNumber(String formula) {
        int dotNumber = 0;
        for (char c : formula.toCharArray()) {
            // If there is anything else except number or dot
            if (!Character.isDigit(c) && c != '.') {
                return false;
            }
            // if there is dor - check it is only one
            if (c == '.') {
                dotNumber++;
                if (dotNumber > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}