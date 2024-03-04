package com.shpp.p2p.cs.aiakovenko.assignment11.tree;

import java.util.List;

/***
 * Interface for every node type to create a BinaryTree
 */
public abstract class Node {
    // String for current node
    String valueString;
    // Link to child nodes
    List<Node> childNodes;

    /***
     * Sets the behavior of the node for calculating and/or value retrieval
     * @return  double as a result
     */
    public abstract double evaluate();

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
}
