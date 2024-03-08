package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticOperators;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.AbstractNode;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;

import java.util.List;

/***
 * Class to save a divider operator as a tree node and set rules for division
 */
public class DivideNode extends AbstractNode {
    Node dividend;
    Node divisor;

    public DivideNode(List<Node> childNodes) {
        super("/", childNodes);
        this.dividend = childNodes.get(0);
        this.divisor = childNodes.get(1);
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
