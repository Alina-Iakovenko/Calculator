package com.shpp.p2p.cs.aiakovenko.assignment11.inputParser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
/***
 * Class to get variables from args, check it and save in HashMap
 */
public class VariableMap implements ArgsParser {
    public static HashMap<String, Double> variables;

    public VariableMap(String[] args) {
        if (args.length > 1) {
            variables = setVariablesFromArgs(args);
        }
    }

    /***
     * Save variables to HashMap if they are correct
     * @param args  String[] with data for variables
     * @return      HashMap with variables` names as keys and their value
     */
    private HashMap<String, Double> setVariablesFromArgs(String[] args) {
        variables = new HashMap<>();
        // Save datas for each variable as an array of String
        String[] variablesStrings = Arrays.copyOfRange(args, 1, args.length);
        // For each variable string
        for (String variableAndValue : variablesStrings) {
            // Remove quotes and spaces
            String clearedVariableAndValue = getClearString(variableAndValue);
            // Divide for name and value
            String[] varAndVal = clearedVariableAndValue.split("=");
            if (isValidInputVariable(varAndVal)) {
                variables.put(varAndVal[0], Double.parseDouble(varAndVal[1]));
            }
        }
        return variables;
    }

    /***
     * Checks if string for variable meets rules
     * @param varAndVal     array with 2 strings - one for name and one for value
     * @return              true if everything is ok, or exception
     * @throws ArrayIndexOutOfBoundsException   if there isn't strings for name and value
     * @throws IllegalArgumentException         if string doesn't meet rules
     */
    private boolean isValidInputVariable(String[] varAndVal) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        // If there isn't strings for name and value
        if (varAndVal.length != 2) {
            throw new ArrayIndexOutOfBoundsException(": string " + Arrays.toString(varAndVal) + " can`t be parsed to variable with value");
        }
        // If variable's name consist not only letters
        if (!varAndVal[0].matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException(": invalid variable name in string: " + Arrays.toString(varAndVal));
        }
        // If variables value isn`t a number
        if (!varAndVal[1].matches("^-?\\d+(\\.\\d+)?$")) {
            throw new IllegalArgumentException(": invalid variable value in string: " + Arrays.toString(varAndVal));
        }
        return true;
    }

    /***
     * Returns value in double for variable
     * @param variableName      String with name for variable to find value
     * @return                  value in double from a map for variable with variableName
     * @throws IllegalArgumentException     if there isn't such a variable name in a map
     */
    public static double getVariablesValue(String variableName) throws IllegalArgumentException{
        Set<String> variablesInMap = variables.keySet();
        for (String variableInMap : variablesInMap) {
            if (variableInMap.equals(variableName)) {
                return variables.get(variableName);
            }
        }
        throw new IllegalArgumentException(": variable from formula isn`t defined in data");
    }

    // we don't use this method now, but may be later...
    /***
     * Changes variable value
     * @param variableName  string with variable name which we will change
     * @param newValue      a double to change to
     */
    void setAnotherValueToVariable(String variableName, double newValue) {
        variables.put(variableName, newValue);
    }
}
