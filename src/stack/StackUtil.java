package stack;

import java.util.Stack;

public class StackUtil {
    public static boolean IsPopOrder(int[] a, int[] b) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            s.push(a[i]);
            while (!s.empty() && s.peek() == b[j]) {
                s.pop();
                j++;
            }
        }
        if (s.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
