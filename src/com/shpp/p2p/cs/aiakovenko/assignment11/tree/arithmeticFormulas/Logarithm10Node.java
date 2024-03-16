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
        double evaluatedArgument = argument.evaluate();
        if (evaluatedArgument <= 0) {
            throw new IllegalArgumentException(" in Log10Node: argument must be greater than 0");
        }
        return Math.log10(evaluatedArgument);
    }
}
