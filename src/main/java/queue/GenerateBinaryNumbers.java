package queue;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class GenerateBinaryNumbers {

    public List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;

        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < n; i++) {
            String current = queue.poll();
            result.add(current);

            queue.offer(current + "0");
            queue.offer(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        GenerateBinaryNumbers generator = new GenerateBinaryNumbers();

        // Example: Generate first 10 binary numbers
        int n = 10;
        List<String> binaryNumbers = generator.generateBinaryNumbers(n);

        System.out.println("First " + n + " binary numbers:");
        for (String binary : binaryNumbers) {
            System.out.println(binary);
        }
    }
}
