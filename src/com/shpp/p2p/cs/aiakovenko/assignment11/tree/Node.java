package com.shpp.p2p.cs.aiakovenko.assignment11.tree;

import java.util.List;

/***
 * An interface for nodes with operators, formulas, numbers and variables,
 * that defines node's common behavior
 */
public interface Node {
    /***
     * Sets the behavior of the node for calculating and/or value retrieval
     * @return  double as a result
     */
    public abstract double evaluate();

    /***
     * Getter for node`s value
     * @return      string for this root
     */
    public String getValueString();
    /***
     * Getter for node's children
     * @return      left child node
     */
    public List<Node> getChildNodes();
}
