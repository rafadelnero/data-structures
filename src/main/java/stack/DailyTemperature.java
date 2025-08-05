package stack;

import java.util.Stack;

/**
 * Given an array of daily temperatures, return an array such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 *
 * For example:
 * Given the list of temperatures [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 */
public class DailyTemperature {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example temperature array
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println("Daily temperatures: ");
        for (int temp : temperatures) {
            System.out.print(temp + " ");
        }
        System.out.println();

        // Calculate wait days for warmer temperatures
        int[] result = dailyTemperatures(temperatures);

        System.out.println("Wait days for warmer temperature: ");
        for (int days : result) {
            System.out.print(days + " ");
        }
        System.out.println();

        // Expected output: [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println("Expected output: [1, 1, 4, 2, 1, 1, 0, 0]");
    }
}
