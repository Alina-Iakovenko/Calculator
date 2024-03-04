package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticOperators;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;

import java.util.List;

/***
 * Class to save a power operator as a tree node and set rules for elevation to a degree
 */
public class PowerNode extends Node {
    String valueString;
    List<Node> childNodes;
    Node base;
    Node power;

    public PowerNode(List<Node> childNodes) {
        this.valueString = "^";
        this.childNodes = childNodes;
        this.base = childNodes.get(0);
        this.power = childNodes.get(1);
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
     * Evaluate value from base node to degree in value of power node
     * @return result in a double
     */
    @Override
    public double evaluate() throws ArithmeticException {
        // we choose to return exception when a result is NaN or infinity,
        // and not to calculate formula till the end
        if (Double.isNaN(Math.pow(base.evaluate(), power.evaluate())) || Double.isInfinite(Math.pow(base.evaluate(), power.evaluate()))) {
            throw new ArithmeticException(" in class PowerNode: Result is undefined (NaN or Infinity) ");
        } else {
            return Math.pow(base.evaluate(), power.evaluate());
        }
    }
}
