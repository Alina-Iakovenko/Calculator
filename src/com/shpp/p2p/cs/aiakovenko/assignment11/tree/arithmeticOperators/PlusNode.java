package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticOperators;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.AbstractNode;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;

import java.util.List;

/***
 * Class to save a plus operator as a tree node and set rules for adding
 */
public class PlusNode extends AbstractNode {
    Node childOne;
    Node childTwo;

    public PlusNode(List<Node> childNodes) {
        super("+",childNodes);
        this.childOne = childNodes.get(0);
        this.childTwo = childNodes.get(1);
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
