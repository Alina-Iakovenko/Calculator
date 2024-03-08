package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas;


public class SquareNode extends ArithmeticFormulaNode {

    public SquareNode(String valueString) {
        super(valueString);
    }

    @Override
    public double evaluate() {
        return Math.sqrt(argument.evaluate());
    }
}
