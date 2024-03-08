package com.shpp.p2p.cs.aiakovenko.assignment11.tree;

import java.util.List;

/***
 * An abstract class for every node type to create a BinaryTree
 * that defined common variables for nodes and implements equal methods
 */
public abstract class AbstractNode implements Node{
    // String for current node
    String valueString = null;
    // Link to child nodes
    List<Node> childNodes;

    /***
     * Constructor to create an object
     * @param valueString   String in root node
     * @param childNodes    List with child nodes
     */
    public AbstractNode(String valueString, List<Node> childNodes) {
        this.valueString = valueString;
        this.childNodes = childNodes;
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
}
