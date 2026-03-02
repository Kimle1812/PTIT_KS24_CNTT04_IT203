package PTIT_CNTT4_IT203_Session15.Exercise03;

import java.util.Stack;

class MedicationProcessChecker {
    private Stack<String> stack = new Stack<>();

    public boolean checkProcess(String[] actions) {
        for (String action : actions) {
            if (action.equals("PUSH")) {
                stack.push("Medicine");
            } else if (action.equals("POP")) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public void reset() {
        stack.clear();
    }
}

public class Exercise03 {
    public static void main(String[] args) {
        MedicationProcessChecker checker = new MedicationProcessChecker();

        String[] actions1 = {"PUSH", "PUSH", "POP", "POP"};
        System.out.println("Quy trình 1 hợp lệ? " + checker.checkProcess(actions1));
        checker.reset();

        String[] actions2 = {"POP", "PUSH"};
        System.out.println("Quy trình 2 hợp lệ? " + checker.checkProcess(actions2));
        checker.reset();

        String[] actions3 = {"PUSH", "PUSH", "POP"};
        System.out.println("Quy trình 3 hợp lệ? " + checker.checkProcess(actions3));
    }
}
