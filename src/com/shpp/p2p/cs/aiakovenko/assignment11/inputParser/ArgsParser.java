package com.shpp.p2p.cs.aiakovenko.assignment11.inputParser;

/***
 * An Interface for parsing classes
 */
public interface ArgsParser {
    /***
     * Deletes quotes at the beginning and at the end of string.
     * Remove spaces.
     * Replace "--" to "+".
     * @param   string a string to check and correct
     * @return  corrected string
     */
    default String getClearString(String string) {
        // Remove quotes if they are at the beginning and at the end
        if (string.startsWith("\"") && string.endsWith("\"")) {
            string = string.substring(1, string.length() - 1);
        }
        // Remove spaces
        string = string.replaceAll("\\s", "");
        // Check if there are 2 unary minuses inline
        if (string.indexOf("---") > -1) {
            throw new IllegalArgumentException(": invalid formula");
        }
        // Replace "--" to "+"
        string = string.replaceAll("--", "+");
        return string;
    }
}
