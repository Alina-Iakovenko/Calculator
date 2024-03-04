package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticOperators;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;

import java.util.List;

/***
 * Class to save a minus operator as a tree node and set rules for subtraction
 */
public class MinusNode extends Node {
    String valueString;
    List<Node> childNodes;
    Node minuend;
    Node subtrahend;

    public MinusNode(List<Node> childNodes) {
        this.valueString = "-";
        this.childNodes = childNodes;
        this.minuend = childNodes.get(0);
        this.subtrahend = childNodes.get(1);
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
     * Substract value of subtrahend node from subtrahend node
     * @return result in a double
     */
    @Override
    public double evaluate() {
        return minuend.evaluate() - subtrahend.evaluate();
    }
}
