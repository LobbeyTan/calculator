import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Calculation {
    public Double calculate(String operation) {
        return postfixEvaluation(infixToPostfix(operation));
    }

    private String infixToPostfix(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<String> stack = new Stack<>();

        ArrayList<String> equation = split(infix);

        for (String element : equation) {
            try {
                output.append(Double.parseDouble(element) + " ");
            } catch (NumberFormatException e) {
                try {
                    if (element.equals("(")) {
                        stack.push(element);
                        continue;
                    }
                    if (element.equals(")")) {
                        while (!stack.peek().equals("(")) output.append(stack.pop() + " ");
                        stack.pop();
                        continue;
                    }
                    if (stack.isEmpty() || stack.peek().equals("(") || precedence(element) > precedence(stack.peek())) {
                        stack.push(element);
                        continue;
                    }
                    while (precedence(element) <= precedence(stack.peek()) && !stack.peek().equals("(") && !stack.peek().equals(")")) {
                        output.append(stack.pop() + " ");
                        if (stack.isEmpty()) break;
                    }
                    stack.push(element);
                } catch (EmptyStackException exception) {
                    return null;
                }
            }
        }

        while(!stack.isEmpty()) output.append(stack.pop() + " ");

        return output.toString();
    }

    private Double postfixEvaluation(String postfix) {
        if (postfix == null) return null;

        String[] equation = postfix.split(" ");
        Stack<String> stack = new Stack<>();

        for (String element : equation) {
            try {
                stack.push(Double.parseDouble(element) + "");
            } catch (NumberFormatException e) {
                try {
                    stack.push(operation(stack.pop(), stack.pop(), element).toString());
                } catch (EmptyStackException exception) {
                    return null;
                }
            }
        }

        return Double.parseDouble(stack.pop());
    }

    private Double operation(String a, String b, String operator) {
        double num_1 = Double.parseDouble(b);
        double num_2 = Double.parseDouble(a);

        return switch (operator) {
            case "+" -> num_1 + num_2;
            case "-" -> num_1 - num_2;
            case "x" -> num_1 * num_2;
            case "÷" -> num_1 / num_2;
            case "%" -> num_1 % num_2;
            default -> null;
        };

    }

    private int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "x", "%", "÷" -> 2;
            default -> -1;
        };
    }

    public ArrayList<String> split(String input) {
        ArrayList<String> arr = new ArrayList<>();

        int j = 0;
        for(int i = 0; i < input.length(); i++) {
            String c = String.valueOf(input.charAt(i));
            if(isOperator(c)) {
                if(j != i) {
                    arr.add(input.substring(j, i));
                    arr.add(input.substring(i, i+1));
                    j = i+1;
                }else{
                    arr.add(input.substring(j, i+1));
                    j++;
                }
            }
        }

        if(j <= input.length()-1) {
            arr.add(input.substring(j));
        }

        return arr;
    }

    private boolean isOperator(String character) {
        String[] operators = {"+", "-", "x", "÷", "(", ")"};

        for(String operator: operators){
            if(character.equals(operator)) return true;
        }
        return false;
    }
}
