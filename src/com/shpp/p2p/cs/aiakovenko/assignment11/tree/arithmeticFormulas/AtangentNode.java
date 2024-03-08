package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas;


public class AtangentNode extends ArithmeticFormulaNode {

    public AtangentNode(String valueString) {
        super(valueString);
    }

    @Override
    public double evaluate() {
        return Math.atan(argument.evaluate());
    }
}
