import java.util.Stack;

class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        // Step 1: Extract digits from right-to-left and push non-zeros to the stack
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                sum += digit;
                stack.push(digit); // Pushing rightmost digits first
            }
            n /= 10;
        }

        long x = 0;
        // Step 2: Pop from the stack to reconstruct the number left-to-right
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            x = x * 10 + digit; // Standard left-to-right number building
        }

        return x * sum;
    }
}