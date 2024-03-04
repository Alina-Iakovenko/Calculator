package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticOperators;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;

import java.util.List;

/***
 * Class to save a plus operator as a tree node and set rules for adding
 */
public class PlusNode extends Node {
    String valueString;
    List<Node> childNodes;
    Node childOne;
    Node childTwo;

    public PlusNode(List<Node> childNodes) {
        this.valueString = "+";
        this.childNodes = childNodes;
        this.childOne = childNodes.get(0);
        this.childTwo = childNodes.get(1);
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
     * Add values of child nodes
     * @return result in a double
     */
    @Override
    public double evaluate() {
        return childOne.evaluate() + childTwo.evaluate();
    }
}
