package stacks_queues_linked_lists.assignment_problems;
import java.util.ArrayDeque;
import java.util.Deque;
public class HackathonBannerPrinter {
    public static String expandBanner(String code) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> previous = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int i = 0;
        while (i < code.length()) {
            char ch = code.charAt(i);
            if (Character.isDigit(ch)) {
                int count = 0;
                while (i < code.length() && Character.isDigit(code.charAt(i))) {
                    count = count * 10 + code.charAt(i) - '0';
                    i++;
                }
                counts.push(count);
            } else if (ch == '[') {
                previous.push(current);
                current = new StringBuilder();
                i++;
            } else if (ch == ']') {
                int repeat = counts.pop();
                String part = current.toString();
                current = previous.pop();
                for (int j = 0; j < repeat; j++) current.append(part);
                i++;
            } else {
                current.append(ch);
                i++;
            }
        }
        return current.toString();
    }
    public static void main(String[] args) {
        System.out.println(expandBanner("3[ab]2[c]"));
        System.out.println(expandBanner("2[x3[y]]z"));
    }
}