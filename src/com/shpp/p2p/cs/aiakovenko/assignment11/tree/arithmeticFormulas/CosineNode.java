package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas;


public class CosineNode extends ArithmeticFormulaNode {

    public CosineNode(String valueString) {
        super(valueString);
    }

    @Override
    public double evaluate() {
        return Math.cos(argument.evaluate());
    }
}
