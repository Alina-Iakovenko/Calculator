package com.shpp.p2p.cs.aiakovenko.assignment11.tree;

public class BracketsNode extends AbstractNode{
    // String from brackets
    String peaceOfFormula;
    // Tree from the string from brackets
    Node treeFromBrackets;
    // Object of ExpressionParser to be able to parse string
    ExpressionParser parser = new ExpressionParser();

    public BracketsNode(String formulaInBrackets) {
        super(formulaInBrackets,null);
        this.peaceOfFormula = formulaInBrackets;
        // Creates a binary tree from the string in brackets
        this.treeFromBrackets = parser.parseStringToTree(peaceOfFormula);
    }

    /***
     * Getter for node`s value
     * @return      string for this root
     */
    public String getValueString() {
        return peaceOfFormula;
    }

    /***
     * Evaluate a binary tree
     * @return result in double
     */
    @Override
    public double evaluate() {
         return treeFromBrackets.evaluate();
    }
}
