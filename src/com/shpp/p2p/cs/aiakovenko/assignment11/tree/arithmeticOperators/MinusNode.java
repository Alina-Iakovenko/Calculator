package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticOperators;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.AbstractNode;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;

import java.util.List;

/***
 * Class to save a minus operator as a tree node and set rules for subtraction
 */
public class MinusNode extends AbstractNode {
    Node minuend;
    Node subtrahend;

    public MinusNode(List<Node> childNodes) {
        super("-", childNodes);
        this.minuend = childNodes.get(0);
        this.subtrahend = childNodes.get(1);
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
