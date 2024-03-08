package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.AbstractNode;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.ExpressionParser;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;

public abstract class ArithmeticFormulaNode extends AbstractNode {
    // object for a new tree created from the string in brackets
    Node argument;
    // An ExpressionParser object to use parseStringToTree() method
    ExpressionParser parser = new ExpressionParser();

    /***
     * A constructor
     * @param valueString   String from brackets
     */
    public ArithmeticFormulaNode(String valueString) {
        super(valueString, null);
        argument = parser.parseStringToTree(valueString);
    }

}
