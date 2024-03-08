package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticOperators;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.AbstractNode;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;

import java.util.List;

/***
 * Class to save a multiply operator as a tree node and set rules for multiplication
 */
public class MultiplyNode extends AbstractNode {
    Node childOne;
    Node childTwo;

    public MultiplyNode(List<Node> childNodes) {
        super("*", childNodes);
        this.childOne = childNodes.get(0);
        this.childTwo = childNodes.get(1);
    }

    /***
     * Multiply values of child nodes
     * @return result in a double
     */
    @Override
    public double evaluate() {
        // for case -x*0 to prevent -0.0
        if (childOne.evaluate() == 0.0 || childTwo.evaluate() == 0.0) {
            return 0.0;
        }
        return childOne.evaluate() * childTwo.evaluate();
    }

}
