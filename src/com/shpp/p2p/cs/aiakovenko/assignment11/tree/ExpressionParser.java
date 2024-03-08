package com.shpp.p2p.cs.aiakovenko.assignment11.tree;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticOperators.*;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas.*;

import java.util.*;

/***
 * Class to create BinaryTree with arithmetic formula from string
 */
public class ExpressionParser {

    /***
     * Parse string to BinaryTree to save formula
     * @param formula   string with formula
     * @return Binary tree with arithmetic formula
     * @throws IllegalArgumentException     if there are some mistakes in formula
     *                                      that wasn't caught before
     */

    public Node parseStringToTree(String formula) throws IllegalArgumentException {
        //find first "+"
        int indexOfPlus = checkSign('+', formula);
        if (indexOfPlus > 0) {
            AbstractNode root = new PlusNode(createChildNotes(formula, indexOfPlus));
            return root;
        }
        //find first "-"
        int indexOfMinus = checkSign('-', formula);
        /* Check if
         * the minus is unary (is the first or precede by another sign),
         * and there is another minus
         * then identify the second one as the current one.
         */
        if (indexOfMinus == 0 ||
                (indexOfMinus > 0 && (formula.charAt(indexOfMinus - 1) == '*'
                        || formula.charAt(indexOfMinus - 1) == '/'
                        || formula.charAt(indexOfMinus - 1) == '^'))) {
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
            AbstractNode root = new MinusNode(createChildNotes(formula, indexOfMinus));
            return root;
        }

        //find first "*"
        int indexOfMultiply = checkSign('*', formula);
        if (indexOfMultiply > 0) {
            AbstractNode root = new MultiplyNode(createChildNotes(formula, indexOfMultiply));
            return root;
        }
        //find first "/"
        int indexOfDivision = checkSign('/', formula);
        if (indexOfDivision > 0) {
            AbstractNode root = new DivideNode(createChildNotes(formula, indexOfDivision));
            return root;
        }
        //find first "^"
        int indexOfPower = checkSign('^', formula);
        if (indexOfPower > 0) {
            AbstractNode root = new PowerNode(createChildNotes(formula, indexOfPower));
            return root;
        }
        //find first unary "-"
        if (formula.indexOf('-') == 0) {
            List<Node> childNodes = new ArrayList<>();
            String childNodeString = formula.substring(1);
            Node childNode = parseStringToTree(childNodeString);
            childNodes.add(childNode);
            childNodes.add(null);
            AbstractNode root = new UnaryMinusNode(childNodes);
            return root;
        }
        //find a number (contains only digits and period)
        if (ValueNode.isNumber(formula)) {
            AbstractNode root = new ValueNode(formula);
            return root;
        }
        //find a valid variable (contains only letters)
        if (VariableNode.isValidVariableName(formula)) {
            Node root = new VariableNode(formula);
            return root;
        }
        // brackets
        if (formula.charAt(0) == '(' && formula.charAt(formula.length()-1) == ')') {
            Node root = new BracketsNode(formula.substring(1,formula.length()-1));
            return root;
        }
        // arithmetic formulas
        if (formula.startsWith("sin(")){
            Node root = new SineNode(formula.substring(4, formula.length()-1));
            return root;
        }
        if (formula.startsWith("cos(")){
            Node root = new CosineNode(formula.substring(4, formula.length()-1));
            return root;
        }
        if (formula.startsWith("tan(")){
            Node root = new TangentNode(formula.substring(4, formula.length()-1));
            return root;
        }
        if (formula.startsWith("atan(")){
            Node root = new AtangentNode(formula.substring(5, formula.length()-1));
            return root;
        }
        if (formula.startsWith("log10(")){
            Node root = new Logarithm10Node(formula.substring(6, formula.length()-1));
            return root;
        }
        if (formula.startsWith("log2(")){
            Node root = new LogarithmNode(formula.substring(5, formula.length()-1));
            return root;
        }
        if (formula.startsWith("sqrt(")){
            Node root = new SquareNode(formula.substring(5, formula.length()-1));
            return root;
        }
        else {
            throw new IllegalArgumentException(": formula isn`t valid");
        }
    }

    /***
     * Find sign in formula out of brackets
     * @param sign      sign to find
     * @param formula   string to check
     * @return          index of sign or -1 if sign is absent
     */
    public int checkSign(char sign, String formula) {
        Deque<Character> brackets = new ArrayDeque<>();
        // find the latest minus
        if (sign == '-') {
            for (int i = formula.length() - 1; i > 0; i--) {
                if (formula.charAt(i) == ')') {
                    brackets.push(formula.charAt(i));
                }
                if (formula.charAt(i) == '(') {
                    brackets.pop();
                }
                if (formula.charAt(i) == sign && brackets.isEmpty()) {
                    return i;
                }
            }
        }
        // find the first occurrence out of brackets of given sign
        else {
            for (int i = 0; i < formula.length(); i++) {
                if (formula.charAt(i) == '(') {
                    brackets.push(formula.charAt(i));
                }
                if (formula.charAt(i) == ')') {
                    brackets.pop();
                }
                if (formula.charAt(i) == sign && brackets.isEmpty()) {
                    return i;
                }
            }
        }
        return -1;
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

