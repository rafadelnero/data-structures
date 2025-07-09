
// Problem: Count the frequency of each character in a string.
void main() {
    var result = countCharacters("abaccdeff");
    System.out.println(result);
}

public Map<Character, Integer> countCharacters(String str) {
    if (str == null || str.isEmpty()) {
        return new HashMap<>();
    }

    Map<Character, Integer> freqMap = new HashMap<>();

    for (char c : str.toCharArray()) {
        // Increment count or initialize to 1 if not present
        freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }

    return freqMap;
}
