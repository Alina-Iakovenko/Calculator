package com.shpp.p2p.cs.aiakovenko.assignment11;

import com.shpp.p2p.cs.aiakovenko.assignment11.inputParser.FormulaString;
import com.shpp.p2p.cs.aiakovenko.assignment11.inputParser.VariableMap;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.ExpressionParser;

import java.util.HashMap;

/***
 * Simple calculator that receives formula and variables
 * in a String[] as parameters for main, and return result as double.
 * Supported operators: +, -, *, /, ^
 * Supported variables should consist only of letters.
 */
public class Assignment11Part1 {
    public static void main(String[] args) {
        try {
            // Get formula from args and do primary check
            FormulaString formula = new FormulaString(args);
            // Get variables from args and do primary check
            VariableMap variables = new VariableMap(args);
            // Calculate formula and print result
            System.out.println(calculate(formula.formula, variables.variables));
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
    public static double calculate(String formula, HashMap<String, Double> variables) {
        // Parse formula to BinaryTree
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula);
//        formulaParser.preOrderTraverseTree(tree);
//        System.out.println("");
        // Check if there are variables in formula and if they are in HashMap
        formulaParser.checkVariablesInTree(tree, variables);
        // Calculate using BinaryTree
        return tree.evaluate();
    }

    /***
     * Method for testing main
     * @param args  given arguments
     */
    public static double testMain(String[] args) {
        FormulaString formula = new FormulaString(args);
        VariableMap variables = new VariableMap(args);
        return calculate(formula.formula, variables.variables);
    }
}