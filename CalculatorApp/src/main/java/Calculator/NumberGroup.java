package Calculator;

/**
 * Represents a mathematical expression encapsulated in a string.
 * This class processes the input expression, validates it, and calculates the result.
 */
public class NumberGroup {
    private final String operation;
    private final double result;

    /**
     * Constructs a NumberGroup object based on the given input expression.
     *
     * @param input The string containing the mathematical expression.
     * @throws ArithmeticException if the input contains alphabetic characters.
     */
    public NumberGroup(String input) {
        this.verifyNoAlphabetWords(input);
        this.operation = input;
        this.result = calculate(input);
    }

    /**
     * Verifies that the input string does not contain alphabetic characters.
     *
     * @param input The string to verify.
     * @throws ArithmeticException if alphabetic characters are found.
     */
    private void verifyNoAlphabetWords(String input) {
        String alphabet = "abcdefghijkmlnñopqrstuvwxyz";
        for (int i = 0; i < input.length(); i++) {
            if (alphabet.indexOf(input.charAt(i)) != -1) {
                throw new ArithmeticException("You can only use numbers and operators.");
            }
        }
    }

    /**
     * Retrieves the calculated result of the mathematical expression.
     *
     * @return The computed result as a double.
     */
    public double getResult() {
        return result;
    }

    /**
     * Retrieves the original mathematical expression.
     *
     * @return The string containing the mathematical expression.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Placeholder method for calculating the result of the expression.
     * Currently returns 0.
     *
     * @param input The mathematical expression to calculate.
     * @return The result of the calculation.
     */
    public double calculate(String input) {
        return 0;
    }

    /**
     * Searches for the innermost subgroup enclosed in parentheses.
     *
     * @return A NumberGroup representing the expression within the deepest set of parentheses.
     */
    private NumberGroup searchForGroups() {
        int indexLeftParenthesis = 0, indexRightParenthesis = 0;

        // Find the last opening parenthesis
        for (int i = 0; i < operation.length(); i++) {
            if (operation.charAt(i) == '(') {
                indexLeftParenthesis = i + 1;
            }
        }

        // Find the first closing parenthesis after the last opening parenthesis
        indexRightParenthesis = operation.indexOf(')', indexLeftParenthesis);

        // Extract the substring between the last '(' and its corresponding ')'
        return new NumberGroup(operation.substring(indexLeftParenthesis, indexRightParenthesis));
    }

    /**
     * Main method for testing the NumberGroup functionality.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        NumberGroup numberGroup = new NumberGroup("+((7-1)-(8+7)+((3-1)(1+2)+1))");
        System.out.println(numberGroup.getOperation());
        System.out.println(numberGroup.searchForGroups().getOperation());
    }
}
