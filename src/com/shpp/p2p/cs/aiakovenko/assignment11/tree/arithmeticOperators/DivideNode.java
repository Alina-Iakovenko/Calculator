package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticOperators;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;

import java.util.List;

/***
 * Class to save a divider operator as a tree node and set rules for division
 */
public class DivideNode extends Node {
    String valueString;
    List<Node> childNodes;
    Node dividend;
    Node divisor;

    public DivideNode(List<Node> childNodes) {
        this.valueString = "/";
        this.childNodes = childNodes;
        this.dividend = childNodes.get(0);
        this.divisor = childNodes.get(1);
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
     * Divide value from dividend node to value of divisor node
     * @return result in a double
     */
    @Override
    public double evaluate() throws ArithmeticException {
        // we choose to return exception when a result is NaN or infinity,
        // and not to calculate formula till the end
        if (Double.isNaN(dividend.evaluate() / divisor.evaluate()) || Double.isInfinite(dividend.evaluate()/ divisor.evaluate())) {
            throw new ArithmeticException(" in class DivideNode: result is undefined (NaN or Infinity)" );
        } else {
            return dividend.evaluate() / divisor.evaluate();
        }
    }
}
