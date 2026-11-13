package stacks_queues_linked_lists.class_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class QuizScoringFormula {
    public static int evaluate(String expr) {
        Deque<Integer> values = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        int i = 0;

        while (i < expr.length()) {
            char ch = expr.charAt(i);

            if (ch == ' ') {
                i++;
            } else if (Character.isDigit(ch)) {
                int number = 0;
                while (i < expr.length()
                        && Character.isDigit(expr.charAt(i))) {
                    number = number * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                values.push(number);
            } else if (ch == '(') {
                operators.push(ch);
                i++;
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    apply(values, operators.pop());
                }
                operators.pop();
                i++;
            } else {
                while (!operators.isEmpty() && operators.peek() != '('
                        && precedence(operators.peek()) >= precedence(ch)) {
                    apply(values, operators.pop());
                }
                operators.push(ch);
                i++;
            }
        }

        while (!operators.isEmpty()) {
            apply(values, operators.pop());
        }

        return values.pop();
    }

    private static int precedence(char operator) {
        return operator == '*' || operator == '/' ? 2 : 1;
    }

    private static void apply(Deque<Integer> values, char operator) {
        int right = values.pop();
        int left = values.pop();

        switch (operator) {
            case '+': values.push(left + right); break;
            case '-': values.push(left - right); break;
            case '*': values.push(left * right); break;
            case '/': values.push(left / right); break;
            default: throw new IllegalArgumentException("Unknown operator");
        }
    }

    public static void main(String[] args) {
        System.out.println(evaluate("2 * (3 + 4) - 10 / 5"));
        System.out.println(evaluate("(8 - 2) * (1 + 2) / 4"));
    }
}

// Time: O(n), Space: O(n).
