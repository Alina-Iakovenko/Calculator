package com.shpp.p2p.cs.aiakovenko.assignment11.inputParser;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/***
 * Class to get formula from args, check it and save in String
 */
public class FormulaString implements ArgsParser {
    public String formula;

    public FormulaString(String[] args) throws RuntimeException, IllegalArgumentException {
        if (args.length > 0) {
            // Remove quotes, spaces and replace -- to +
            String formulaString = getClearString(args[0].trim());
            if (isValidFormula(formulaString) && areValidBrackets(formulaString)) {
                this.formula = formulaString;
            }
        } else {
            throw new RuntimeException(": no formula found");
        }

    }

    /***
     * Checks if string meets formula rules
     * @param formula   string to check
     * @return true if everything is correct or Exception if sth is wrong
     * @throws IllegalArgumentException if string doesn`t match formula rules
     */
    protected boolean isValidFormula(String formula) throws IllegalArgumentException {
        char[] charArray = formula.toCharArray();
        // Check if string begins with a letter, a number or minus
        if (charArray[0] != '-' && !Character.isDigit(charArray[0]) && !Character.isLetter(charArray[0]) && charArray[0] != '(') {
            throw new IllegalArgumentException(": string doesn`t match formula rules (wrong first symbol)");
        }
        // Check if string ends with a letter or a number
        if (!Character.isDigit(charArray[charArray.length - 1]) && !Character.isLetter(charArray[charArray.length - 1]) && charArray[charArray.length - 1] != ')') {
            throw new IllegalArgumentException(": string doesn`t match formula rules (wrong last symbol)");
        }
        // Check if there isn't any wrong symbol in string (not a letter, a number, a dot or an operator
        for (int i = 0; i < charArray.length - 1; i++) {
            if (!Character.isDigit(charArray[i])
                    && !Character.isLetter(charArray[i])
                    && charArray[i] != '+' && charArray[i] != '-'
                    && charArray[i] != '*' && charArray[i] != '/'
                    && charArray[i] != '^' && charArray[i] != '.'
                    && charArray[i] != '(' && charArray[i] != ')') {
                throw new IllegalArgumentException(": string doesn`t match formula rules  (wrong symbol inside)");
            }
            // Check if there isn't to operators inline (except 2 unary minuses because we checked it earlier)
            if ((charArray[i] == '+' || charArray[i] == '-'
                    || charArray[i] == '*' || charArray[i] == '/'
                    || charArray[i] == '^')
                    && (charArray[i + 1] == '+' || charArray[i + 1] == '*'
                    || charArray[i + 1] == '/' || charArray[i + 1] == '^')) {
                throw new IllegalArgumentException(": string doesn`t match formula rules");
            }
            // Check for empty brackets
            if (charArray[i] == '(' && charArray[i + 1] == ')') {
                throw new IllegalArgumentException(": string doesn`t match formula rules because there are empty brackets");
            }
//            // check if there isn't a case with brackets without an operator if brackets isn't the first or the latest
//            if (charArray[i] == '(' && ((i > 0) && charArray[i - 1] != '+'
//                    && charArray[i - 1] != '-' && charArray[i - 1] != '*'
//                    && charArray[i - 1] != '/' && charArray[i - 1] != '^'
//                    && charArray[i - 1] != '(')) {
//                throw new IllegalArgumentException(": string doesn`t match formula rules because there are brackets without operator before");
//            }
//            if (charArray[i] == ')' && ((i < charArray.length - 1) && charArray[i + 1] != '+'
//                    && charArray[i + 1] != '-' && charArray[i + 1] != '*'
//                    && charArray[i + 1] != '/' && charArray[i + 1] != '^'
//                    && charArray[i + 1] != ')')) {
//                throw new IllegalArgumentException(": string doesn`t match formula rules because there are brackets without operator after");
//            }
        }
        return true;
    }

    /***
     * Check if all open bracket matches close bracket in formula
     * @param formula   String to check
     * @return          true if the formula is correct
     * @throws IllegalArgumentException        if brackets in string don't match formula rules
     */
    public static boolean areValidBrackets(String formula) throws IllegalArgumentException{
        Deque<Character> brackets = new ArrayDeque<>();
        for (Character character : formula.toCharArray()) {
            if (character == '(') {
                brackets.push(character);
            }
            if (character == ')') {
                if (brackets.isEmpty()) {
                    throw new IllegalArgumentException(": brackets in string doesn`t match formula rules");
                } else {
                    brackets.pop();
                }
            }
        }
        if (!brackets.isEmpty()) {
            throw new IllegalArgumentException(": brackets in string doesn`t match formula rules");
        }
        return true;
    }
}

