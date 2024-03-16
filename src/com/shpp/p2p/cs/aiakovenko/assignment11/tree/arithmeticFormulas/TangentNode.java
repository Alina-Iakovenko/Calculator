package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas;


public class TangentNode extends ArithmeticFormulaNode {

    public TangentNode(String valueString) {
        super(valueString);
    }

    @Override
    public double evaluate() {
        double evaluatedArgument = argument.evaluate();
        if (Math.abs(evaluatedArgument - Math.PI/2) % Math.PI == 0) {
            throw new IllegalArgumentException(" in TangentNode: argument is out of the valid range");
        }
        return Math.tan(evaluatedArgument);
    }
}
