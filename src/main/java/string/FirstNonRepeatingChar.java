package string;

import java.util.LinkedHashMap;
import java.util.Map;

// Problem: Find the first character in a string that does not repeat.
public class FirstNonRepeatingChar {

    void main() {
        var result = firstNonRepeatingChar("abacdeff");
        System.out.println(result);
    }

    public char firstNonRepeatingChar(String str) {
        // Use LinkedHashMap to maintain insertion order
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        // Count occurrences of each character
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Find first character with count = 1
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0'; // Return null character if not found
    }
}
