package stackandqueue.stockspanproblem;

import java.util.Stack;

class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stack stores indices

        for (int i = 0; i < n; i++) {
            // Pop elements while stack is not empty and current price is higher
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, all previous elements were smaller
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push current index to stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);

        // Print the result
        System.out.println("Stock Span:");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}
