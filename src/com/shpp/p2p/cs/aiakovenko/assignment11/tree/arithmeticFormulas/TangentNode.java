package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas;


public class TangentNode extends ArithmeticFormulaNode {

    public TangentNode(String valueString) {
        super(valueString);
    }

    @Override
    public double evaluate() {
        return Math.tan(argument.evaluate());
    }
}
