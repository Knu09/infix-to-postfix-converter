
package infixpostfix;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToPostfixCalculator {
    String postfix;

    ArrayList<String> stackTable = new ArrayList<>();
    ArrayList<String> postfixTable = new ArrayList<>();
    public InfixToPostfixCalculator(String infixString) {
        this.postfix = "";
        Stack<String> stack = new Stack<>();
        String [] character = infixString.split("(?<=\\D)|(?=\\D)");
        for (String c : character) { //digit
            if (isNotOperator(c) && isParenthesis(c)) {
                this.postfix += c + " ";
            } else if (c.equals("(")) {
                stack.push(c);
            } else if (c.equals(")")) {
                while (!stack.isEmpty()) {
                    String elmnts = stack.pop();
                    if (!elmnts.equals("(")) {
                        this.postfix += elmnts + " ";
                    } else {
                        break;
                    }
                }
                // operates if the element is operator
            } else if (isOperator(c)) {
                if (stack.isEmpty()) {       // push in Stack if the Stack's size is Empty
                    stack.push(c);

                } else {
                    while (!stack.isEmpty()) {       // if not empty pop's Stack to 'elmnts' Variable
                        String elmnts = stack.pop();
                        if (elmnts.equals("(")) {
                            stack.push(elmnts);
                            break;
                        } else if (isOperator(elmnts)) {
                            if (Precedence(elmnts) < Precedence(c)) {
                                stack.push(elmnts);     // push 'elmnts' in stack if 'elmnts' is less than 'c'
                                break;
                            } else {
                                this.postfix += elmnts + " ";
                            }
                        }
                    }
                    stack.push(c);
                }
            }
            //gathers each values of stack and postfix within the loop
            this.stackTable.add(String.valueOf(stack));
            this.postfixTable.add(this.postfix);
        }

        // pop all remaining elements inside the stack
        while (!stack.isEmpty()) {
//            if(stackTable.get(stackTable.size()-1).contains(String.valueOf(stack.peek()))){ 
//                this.stackTable.add("[]"); //to make the stackTable
//            }
            this.postfix += stack.pop() + " ";
            stackTable.add(String.format("%s", stack));
            this.postfixTable.add(this.postfix);

        }
        System.out.println(this.stackTable);
        System.out.println(this.postfixTable);
    }

    public String displayPostfix() {     // displays the postfix
        return this.postfix;
    }
    public ArrayList<String> getStackTable() {
        return stackTable;
    }

    public ArrayList<String> getPostfixTable() {
        return postfixTable;
    }
    public boolean isParenthesis(String c){
        return !c.equals("(") && !c.equals(")");
    }
    public boolean isOperator(String c){
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^");
    }
    public boolean isNotOperator(String c){
        return !c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")
                && !c.equals("^");
    }
    public int Precedence(String c) {     // Priority Identifier for operator
        // if operator is (+, -) Precedence adds 1
        if (c.equals("+")) {
            return 1;
        } else if (c.equals("-")) {
            return 1;

            // if operator is (*, /) Precedence adds 2
        } else if(c.equals("^")){
            return 3;
        } else {
            return 2;
        }
    }

    public static double showResult(String infixString) {

        Stack<Double> stack = new Stack<>();        //import Stack

        String[] postfixArrays = infixString.split(" ");       // convert postfix expression to String Arrays and Splits the infixString to one space
        for (String element : postfixArrays){     // for loop each of the postfixArrays
            if (element.matches("[0-9]+")) {     // checks if the elements contains natural numbers
                stack.push((Double.parseDouble(element)));       // converts it to a Double and pushes it onto the stack.
            } else {
                double num2 = stack.pop();      // pop the 2nd element in the Stack
                double num1 = stack.pop();      // pop the 1st element in the Stack
                double result = 0;

                switch (element) {      // Checks the operator then solve for the result
                    case "+" -> result = num1 + num2;
                    case "-" -> result = num1 - num2;
                    case "*" -> result = num1 * num2;
                    case "/" -> {
                        if (num2 == 0) {
                            throw new ArithmeticException("Cannot divide by zero");     // if the denominator is 0
                        }
                        result = num1 / num2;
                    }
                    case "^" -> result = Math.pow(num1, num2);
                    default -> System.out.print("Unknown Operator");       // if the operator is unknown
                }
                stack.push(result);         // pushes to the Stack
            }
        }
        return stack.pop();     // pops then return the Stack
    }

}