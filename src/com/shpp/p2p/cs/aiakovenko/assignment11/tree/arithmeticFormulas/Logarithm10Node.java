package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.AbstractNode;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.ExpressionParser;

public class Logarithm10Node extends ArithmeticFormulaNode {

    public Logarithm10Node(String valueString) {
        super(valueString);
    }

    @Override
    public double evaluate() {
        return Math.log10(argument.evaluate());
    }
}
