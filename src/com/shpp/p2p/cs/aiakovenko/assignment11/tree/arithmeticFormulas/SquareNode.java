package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas;


public class SquareNode extends ArithmeticFormulaNode {

    public SquareNode(String valueString) {
        super(valueString);
    }

    @Override
    public double evaluate() {
        double evaluatedArgument = argument.evaluate();
        if (evaluatedArgument < 0) {
            throw new IllegalArgumentException(" in SqrtNode: argument must be non-negative");
        }
        return Math.sqrt(evaluatedArgument);
    }
}
