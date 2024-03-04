package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticOperators;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;

import java.util.List;

/***
 * Class to save a unary minus operator as a tree node and set rules for it.
 * In this conception it has only one child node
 */
public class UnaryMinusNode extends Node {
    String valueString;
    List<Node> childNodes;
    Node childNode;

    public UnaryMinusNode(List<Node> childNodes) {
        this.valueString = "-(unary)";
        this.childNodes = childNodes;
        this.childNode = childNodes.get(0);
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
     * Change sign of child node
     * @return result in a double
     */
    @Override
    public double evaluate() {
        // to prevent -0.0 in a result
        if (childNode.evaluate() == 0.0) {
            return childNode.evaluate();
        }
        return -1.0 * (childNode.evaluate());
    }
}
