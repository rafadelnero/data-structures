package string;

// Problem: Determine if a string reads the same forward and backward.
public class Palindrome {

    void main() {
        isPalindrome("Ana");
    }

    public boolean isPalindrome(String str) {
        // Handle edge cases
        if (str == null || str.length() <= 1) {
            return true;
        }

        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Two-pointer approach
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
