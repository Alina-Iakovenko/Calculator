package com.shpp.p2p.cs.aiakovenko.assignment11.tree;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.arithmeticFormulas.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
        Node root;

        root = getPlusNode(formula);
        if (root != null) return root;

        root = getMinusNode(formula);
        if (root != null) return root;

        root = getMultiplyNode(formula);
        if (root != null) return root;

        root = getDivideNode(formula);
        if (root != null) return root;

        root = getPowerNode(formula);
        if (root != null) return root;

        root = getUnaryMinusNode(formula);
        if (root != null) return root;

        root = getNumberNode(formula);
        if (root != null) return root;

        root = getVariableNode(formula);
        if (root != null) return root;

        root = getBracketsNode(formula);
        if (root != null) return root;

        root = getFormulaNode(formula);
        if (root != null) return root;

        else {
            throw new IllegalArgumentException(": formula isn`t valid");
        }
    }

    /**
     * Creates one of ArithmeticFormulaNode concrete class
     *
     * @param formula string with formula to check
     * @return instance of class or null
     */
    private Node getFormulaNode(String formula) {
        try {
            HashMap<String, Class<? extends ArithmeticFormulaNode>> arithmeticFormulas = getFormulasMap();
            for (String formulaStart : arithmeticFormulas.keySet()) {
                if (formula.startsWith(formulaStart)) {
                    String argument = formula.substring(formulaStart.length(), formula.length() - 1);
                    Class<? extends ArithmeticFormulaNode> aClass = arithmeticFormulas.get(formulaStart);
                    Constructor<? extends ArithmeticFormulaNode> constructor = aClass.getConstructor(String.class);
                    return constructor.newInstance(argument);
                }
            }
            return null;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates HashMap with one of possible starts of string with arithmetic formula and class for it
     *
     * @return HashMap
     */
    private HashMap<String, Class<? extends ArithmeticFormulaNode>> getFormulasMap() {
        HashMap<String, Class<? extends ArithmeticFormulaNode>> formulas = new HashMap<>();
        formulas.put("sin(", SineNode.class);
        formulas.put("cos(", CosineNode.class);
        formulas.put("tan(", TangentNode.class);
        formulas.put("atan(", AtangentNode.class);
        formulas.put("log10(", Logarithm10Node.class);
        formulas.put("log2(", Logarithm2Node.class);
        formulas.put("sqrt(", SquareNode.class);
        return formulas;
    }

    /**
     * Creates new instance of BracketsNode if sign '(' is found
     *
     * @param formula string to parse
     * @return BracketsNode or null
     */
    private Node getBracketsNode(String formula) {
        if (formula.charAt(0) == '(' && formula.charAt(formula.length() - 1) == ')') {
            Node root = new BracketsNode(formula.substring(1, formula.length() - 1));
            return root;
        }
        return null;
    }

    /**
     * Creates new instance of VariableNode if a string is variable
     *
     * @param formula string to parse
     * @return VariableNode or null
     */
    private Node getVariableNode(String formula) {
        if (VariableNode.isValidVariableName(formula)) {
            Node root = new VariableNode(formula);
            return root;
        }
        return null;
    }

    /**
     * Creates new instance of NumberNode if a string is a number
     *
     * @param formula string to parse
     * @return NumberNode or null
     */
    private AbstractNode getNumberNode(String formula) {
        if (formula.matches("^-?\\d+(\\.\\d+)?$")) {//
            /**
             * An anonymous class to save a number as a tree node and set rules for this node
             * This is always a leaf node that's why it hasn't children
             */
            AbstractNode root = new AbstractNode(formula, null) {
                /**
                 * This node just returns its value and calculates anything
                 * @return double
                 */
                @Override
                public double evaluate(){
                        return Double.parseDouble(formula);
                }
            };
            return root;
        }
        return null;
    }

    /**
     * Creates new instance of UnaryNode if unary minus is found
     *
     * @param formula string to parse
     * @return UnaryNode or null
     */
    private AbstractNode getUnaryMinusNode(String formula) {
        if (formula.indexOf('-') == 0) {
            List<Node> childNodes = new ArrayList<>();
            String childNodeString = formula.substring(1);
            Node childNode = parseStringToTree(childNodeString);
            childNodes.add(childNode);
            childNodes.add(null);
            /**
             * An anonymous to save a unary minus operator as a tree node and set rules for it.
             * In this conception it has only one child node
             */
            AbstractNode root = new AbstractNode("-(unary)", childNodes) {
                /**
                 * Change sign of child node
                 * @return result in a double
                 */
                @Override
                public double evaluate() {
                    // to prevent -0.0 in a result
                    if (childNode.evaluate() == 0.0) {
                        return childNode.evaluate();
                    }
                    return -1.0 * (childNode.evaluate());
                }
            };
            return root;
        }
        return null;
    }

    /**
     * Creates new instance of PowerNode if sign '^' is found
     *
     * @param formula string to parse
     * @return PowerNode or null
     */
    private AbstractNode getPowerNode(String formula) {
        int indexOfPower = checkSign('^', formula);
        if (indexOfPower > 0) {
            /***
             * An anonymous class to save a power operator as a tree node and set rules for elevation to a degree
             */
            AbstractNode root = new AbstractNode("^", createChildNotes(formula, indexOfPower)) {
                /***
                 * Evaluate value from base node to degree in value of power node
                 * @return result in a double
                 */
                @Override
                public double evaluate() throws ArithmeticException {
                    // we choose to return exception when a result is NaN or infinity,
                    // and not to calculate formula till the end
                    if (Double.isNaN(Math.pow(getFirstChildNode().evaluate(), getSecondChildNode().evaluate()))
                            || Double.isInfinite(Math.pow(getFirstChildNode().evaluate(), getSecondChildNode().evaluate()))) {
                        throw new ArithmeticException(" result is undefined (NaN or Infinity) in getting to power");
                    } else {
                        return Math.pow(getFirstChildNode().evaluate(), getSecondChildNode().evaluate());
                    }
                }
            };
            return root;
        }
        return null;
    }

    /**
     * Creates new instance of DivideNode if sign '/' is found
     *
     * @param formula string to parse
     * @return DivideNode or null
     */
    private AbstractNode getDivideNode(String formula) {
        int indexOfDivision = checkSign('/', formula);
        if (indexOfDivision > 0) {
            /***
             * An anonymous class to save a divider operator as a tree node and set rules for division
             */
            AbstractNode root = new AbstractNode("/", createChildNotes(formula, indexOfDivision)) {
                /***
                 * Divide value from dividend node to value of divisor node
                 * @return result in a double
                 */
                @Override
                public double evaluate() throws ArithmeticException {
                    // we choose to return exception when a result is NaN or infinity,
                    // and not to calculate formula till the end
                    if (Double.isNaN(getFirstChildNode().evaluate() / getSecondChildNode().evaluate())
                            || Double.isInfinite(getFirstChildNode().evaluate()/ getSecondChildNode().evaluate())) {
                        throw new ArithmeticException(" result is undefined (NaN or Infinity) in division" );
                    } else {
                        return getFirstChildNode().evaluate() / getSecondChildNode().evaluate();
                    }
                }
            };
            return root;
        }
        return null;
    }

    /**
     * Creates new instance of MultiplyNode if sign '*' is found
     *
     * @param formula string to parse
     * @return MultiplyNode or null
     */
    private AbstractNode getMultiplyNode(String formula) {
        int indexOfMultiply = checkSign('*', formula);
        if (indexOfMultiply > 0) {
            /**
             * An anonymous class to save a multiply operator as a tree node and set rules for multiplication
             */
            AbstractNode root = new AbstractNode("/", createChildNotes(formula, indexOfMultiply)) {
                /***
                 * Multiply values of child nodes
                 * @return result in a double
                 */
                @Override
                public double evaluate() {
                    // for case -x*0 to prevent -0.0
                    if (getFirstChildNode().evaluate() == 0.0 || getSecondChildNode().evaluate() == 0.0) {
                        return 0.0;
                    }
                    return getFirstChildNode().evaluate() * getSecondChildNode().evaluate();
                }
            };
            return root;
        }
        return null;
    }

    /**
     * Creates new instance of MinusNode if sign '-' is found
     *
     * @param formula string to parse
     * @return MinusNode or null
     */
    private AbstractNode getMinusNode(String formula) {
        int indexOfMinus = checkSign('-', formula);
        /* Check if
         * the minus is unary (is the first or precede by another sign),
         * and there is another minus
         * then identify the second one as the current one.
         */
        if (indexOfMinus == 0 ||
                (indexOfMinus > 0 && (formula.charAt(indexOfMinus - 1) == '*'
                        || formula.charAt(indexOfMinus - 1) == '/'
                        || formula.charAt(indexOfMinus - 1) == '^'))
                        && formula.charAt(indexOfMinus + 1) != '(') {
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
            /**
             * An anonymous class to save a minus operator as a tree node and set rules for subtraction
             */
            AbstractNode root = new AbstractNode("/", createChildNotes(formula, indexOfMinus)) {
                /**
                 * Substract value of subtrahend node from subtrahend node
                 * @return result in a double
                 */
                @Override
                public double evaluate() {
                    return getFirstChildNode().evaluate() - getSecondChildNode().evaluate();
                }
            };
            return root;
        }
        return null;
    }

    /**
     * Creates new instance of PlusNode if sign '+' is found
     *
     * @param formula string to parse
     * @return PlusNode or null
     */
    private AbstractNode getPlusNode(String formula) {
        int indexOfPlus = checkSign('+', formula);
        if (indexOfPlus > 0) {
            /***
             * An anonymous class to save a plus operator as a tree node and set rules for adding
             */
            AbstractNode root = new AbstractNode("/", createChildNotes(formula, indexOfPlus)) {
                /***
                 * Add values of child nodes
                 * @return result in a double
                 */
                @Override
                public double evaluate() {
                    return getFirstChildNode().evaluate() + getSecondChildNode().evaluate();
                }
            };
            return root;
        }
        return null;
    }

    /**
     * Find sign in formula out of brackets
     *
     * @param sign    sign to find
     * @param formula string to check
     * @return index of sign or -1 if sign is absent
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

    /**
     * Creates left and right child nodes
     *
     * @param formula     string to parse to nodes
     * @param indexOfSign index of sing that is root node and split the string
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

    /**
     * Traverses tree and print every node
     *
     * @param node root node
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

    /**
     * Traverse a tree and check if there are VariableNode
     * and check if there is value for it in data
     *
     * @param node      formula saved in tree structure
     * @param variables HashMap with saved variables with values
     */
    public static void checkVariablesInTree(Node node, HashMap<String, Double> variables) {
        if (node == null) {
            return;
        }
        if (node instanceof VariableNode) {
            if (variables == null) {
                throw new IllegalArgumentException(": no data structure with variables from formula");
            }
            if (variables.containsKey(node.getValueString())) {
                return;
            }
            throw new IllegalArgumentException(": no data for variable from formula");
        }
        if (node.getChildNodes() != null) {
            checkVariablesInTree(node.getChildNodes().get(0), variables);
            checkVariablesInTree(node.getChildNodes().get(1), variables);
        }
    }
}

