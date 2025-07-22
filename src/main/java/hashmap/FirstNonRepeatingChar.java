
// Problem: Find the first non-repeating character in a string.
void main() {
    var result = firstNonRepeatingChar("abacdeff");
    System.out.println(result);
}

public char firstNonRepeatingChar(String str) {
    if (str == null || str.isEmpty()) {
        throw new IllegalArgumentException("String cannot be empty or null");
    }

    // Count frequencies
    Map<Character, Integer> freqMap = new HashMap<>();

    for (char c : str.toCharArray()) {
        freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }

    // Find first character with count 1
    for (char c : str.toCharArray()) {
        if (freqMap.get(c) == 1) {
            return c;
        }
    }

    return '\0'; // No non-repeating character found
}
