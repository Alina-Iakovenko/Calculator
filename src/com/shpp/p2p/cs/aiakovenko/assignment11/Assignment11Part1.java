package com.shpp.p2p.cs.aiakovenko.assignment11;

import com.shpp.p2p.cs.aiakovenko.assignment11.inputParser.FormulaString;
import com.shpp.p2p.cs.aiakovenko.assignment11.inputParser.VariableMap;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.ExpressionParser;

import java.util.HashMap;

/***
 * Simple calculator that receives formula and variables
 * in a String[] as parameters for main, and return result as double.
 * Supported operators: +, -, *, /, ^, unary minus and brackets.
 * Supported arithmetic formulas: sin, cos, tan, atan, log10, log2, sqrt
 *                                with arguments in brackets
 * Supported variables should consist only of letters.
 */
public class Assignment11Part1 {
    public static void main(String[] args) {
        try {
            // Get formula from args, do primary check and parse to BinaryTree
            FormulaString formula = new FormulaString(args);
            ExpressionParser formulaParser = new ExpressionParser();
            Node tree = formulaParser.parseStringToTree(formula.getFormula());

            // Get variables from args
            VariableMap variables = new VariableMap(args);

            // Calculate formula and print result
            System.out.println(calculate(tree, variables.getVariables()));

//            // to show that formula is saved, and we don't need another parsing process:
//            variables.setAnotherValueToVariable("a",10);
//            System.out.println(calculate(tree, variables.getVariables()));
        } catch (Exception e) {
            // Print what was wrong
            System.err.println("Exception occured" + e.getMessage());
        }
    }

    /***
     * Calculate arithmethic formula with or without variables
     * @param formula       String that meets the conditions of the formula
     * @param variables     HashMap with variables that meets the conditions of the variables
     * @return result of calculating in double
     */
    public static double calculate(Node formula, HashMap<String, Double> variables) {
        ExpressionParser.checkVariablesInTree(formula, variables);
        return formula.evaluate();
    }

    /***
     * Method for testing main
     * @param args  given arguments
     */
    public static double testMain(String[] args) {
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        VariableMap variables = new VariableMap(args);
        return calculate(tree, variables.getVariables());
    }
}