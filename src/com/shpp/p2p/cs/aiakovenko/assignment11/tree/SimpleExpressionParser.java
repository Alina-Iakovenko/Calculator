package com.shpp.p2p.cs.aiakovenko.assignment11.tree;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticOperators.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * Class to create BinaryTree with arithmetic formula from string
 */
public class SimpleExpressionParser {
    /***
     * Parse string to BinaryTree to save formula
     * @param formula   string with formula
     * @return Binary tree with arithmetic formula
     * @throws IllegalArgumentException     if there are some mistakes in formula
     *                                      that wasn't caught before
     */

    public Node parseStringToTree(String formula) throws IllegalArgumentException {
        //find first "+"
        int indexOfPlus = formula.indexOf('+');
        if (indexOfPlus > 0) {
            Node root = new PlusNode(createChildNotes(formula, indexOfPlus));
            return root;
        }
        //find first "-"
        int indexOfMinus = formula.lastIndexOf('-');
        /* Check if
         * the minus is unary (is the first or precede by another sign),
         * and there is another minus
         * then identify the second one as the current one.
         */
        if (indexOfMinus == 0 ||
                (indexOfMinus > 0 && (formula.charAt(indexOfMinus - 1) == '*'
                                        || formula.charAt(indexOfMinus - 1) == '/'
                                        || formula.charAt(indexOfMinus - 1) == '^'))){
            int indexOfSecondMinus = formula.indexOf('-', indexOfMinus + 1);
            if (indexOfSecondMinus > -1) {
                indexOfMinus = indexOfSecondMinus;
            }
        }
        // Check if the minus is not unary (found at the first position, or preceded by other operators)
        if (indexOfMinus > 0 && (formula.charAt(indexOfMinus - 1) != '+'
                && formula.charAt(indexOfMinus - 1) != '-'
                && formula.charAt(indexOfMinus - 1) != '*'
                && formula.charAt(indexOfMinus - 1) != '/'
                && formula.charAt(indexOfMinus - 1) != '^')) {
            Node root = new MinusNode(createChildNotes(formula, indexOfMinus));
            return root;
        }

        //find first "*"
        int indexOfMultiply = formula.indexOf('*');
        if (indexOfMultiply > 0) {
            Node root = new MultiplyNode(createChildNotes(formula, indexOfMultiply));
            return root;
        }
        //find first "/"
        int indexOfDivision = formula.indexOf('/');
        if (indexOfDivision > 0) {
            Node root = new DivideNode(createChildNotes(formula, indexOfDivision));
            return root;
        }
        //find first "^"
        int indexOfPower = formula.indexOf('^');
        if (indexOfPower > 0) {
            Node root = new PowerNode(createChildNotes(formula, indexOfPower));
            return root;
        }
        //find first unary "-"
        if (formula.indexOf('-') == 0) {
            List<Node> childNodes = new ArrayList<>();
            String childNodeString = formula.substring(1);
            Node childNode = parseStringToTree(childNodeString);
            childNodes.add(childNode);
            Node root = new UnaryMinusNode(childNodes);
            return root;
        }
        //find a number (contains only digits and period)
        if (ValueNode.isNumber(formula)) {
            Node root = new ValueNode(formula);
            return root;
        }
        //find a valid variable (contains only letters)
        if (VariableNode.isValidVariableName(formula)) {
            Node root = new VariableNode(formula);
            return root;
        } else {
            throw new IllegalArgumentException(": formula isn`t valid");
        }
    }

    /***
     * Creates left and right child nodes
     * @param formula           string to parse to nodes
     * @param indexOfSign       index of sing that is root node and split the string
     * @return array of two child nodes
     */
    private List<Node> createChildNotes(String formula, int indexOfSign) {
        // array of 2 child nodes
        List<Node> childNodes = new ArrayList<>();

        // create left child node
        String leftString = formula.substring(0, indexOfSign);
        Node leftChildNode = parseStringToTree(leftString);
        childNodes.add(leftChildNode);

        // create right child node
        String rightString = formula.substring(indexOfSign + 1);
        Node rightChildNode = parseStringToTree(rightString);
        childNodes.add(rightChildNode);
        // return array
        return childNodes;
    }
    // we don't use it, but it's useful for finding mistakes and is basic for the next method

    /***
     * Traverses tree and print every node
     * @param node  root node
     */
    public void preOrderTraverseTree(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValueString() + " ");
        if (node.getChildNodes() != null) {
            preOrderTraverseTree(node.getChildNodes().get(0));
            preOrderTraverseTree(node.getChildNodes().get(1));
        }
    }

    /***
     * Traverse a tree and check if there are VariableNode
     * and check if there is value for it in data
     * @param node      formula saved in tree structure
     * @param variables HashMap with saved variables with values
     */
    public void checkVariablesInTree(Node node, HashMap<String, Double> variables) {
        if (node == null) {
            return;
        }
        if (node instanceof VariableNode) {
            ((VariableNode) node).checkVariableInMap(variables);
        }
        if (node.getChildNodes() != null) {
            checkVariablesInTree(node.getChildNodes().get(0), variables);
            checkVariablesInTree(node.getChildNodes().get(1), variables);
        }
    }
}

