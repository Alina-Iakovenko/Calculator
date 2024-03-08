package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas;


public class SineNode extends ArithmeticFormulaNode {
    public SineNode(String valueString) {
        super(valueString);
    }
    @Override
    public double evaluate() {
        return Math.sin(argument.evaluate());
    }
}
