package stacks_queues_linked_lists.assignment_problems;
import java.util.ArrayDeque;
import java.util.Deque;
public class QuizScoringFormula {
    public static int evaluate(String expr) {
        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        int i = 0;
        while (i < expr.length()) {
            char ch = expr.charAt(i);
            if (Character.isWhitespace(ch)) i++;
            else if (Character.isDigit(ch)) {
                int number = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    number = number * 10 + expr.charAt(i) - '0';
                    i++;
                }
                numbers.push(number);
            } else if (ch == '(') {
                operators.push(ch);
                i++;
            } else if (ch == ')') {
                while (operators.peek() != '(') applyTop(numbers, operators);
                operators.pop();
                i++;
            } else {
                while (!operators.isEmpty() && operators.peek() != '('
                        && precedence(operators.peek()) >= precedence(ch)) {
                    applyTop(numbers, operators);
                }
                operators.push(ch);
                i++;
            }
        }
        while (!operators.isEmpty()) applyTop(numbers, operators);
        return numbers.pop();
    }
    private static int precedence(char operator) {
        return operator == '*' || operator == '/' ? 2 : 1;
    }
    private static void applyTop(Deque<Integer> numbers, Deque<Character> operators) {
        int right = numbers.pop(), left = numbers.pop();
        char operator = operators.pop();
        if (operator == '+') numbers.push(left + right);
        else if (operator == '-') numbers.push(left - right);
        else if (operator == '*') numbers.push(left * right);
        else numbers.push(left / right);
    }
    public static void main(String[] args) {
        System.out.println(evaluate("2 * (3 + 4) - 10 / 5"));
        System.out.println(evaluate("(8 - 2) * (1 + 2) / 4"));
    }
}