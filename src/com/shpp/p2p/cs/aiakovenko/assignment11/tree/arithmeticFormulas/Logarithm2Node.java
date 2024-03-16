package com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas;

public class Logarithm2Node extends ArithmeticFormulaNode {

    public Logarithm2Node(String valueString) {
        super(valueString);
    }

    @Override
    public double evaluate() {
        double evaluatedArgument = argument.evaluate();
        if (evaluatedArgument <= 0) {
            throw new IllegalArgumentException(" in Log2Node: argument must be greater than 0");
        }
        return Math.log(evaluatedArgument) / Math.log(2);
    }
}
