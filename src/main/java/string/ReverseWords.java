
// Problem: Reverse the order of words in a string while maintaining the word characters in the same order.
public void main() {
    var result = reverseWords("Hello World");
    System.out.println(result);
}

public String reverseWords(String str) {
    // Handle edge cases
    if (str == null || str.trim().isEmpty()) {
        return str;
    }

    // Split string into words
    String[] words = str.trim().split("\\s+");

    // Reverse the array of words
    StringBuilder result = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
        result.append(words[i]);
        if (i > 0) {
            result.append(" ");
        }
    }

    return result.toString();
}
