package string;

// Problem: Determine if two strings use exactly the same characters with the same frequency.
public class Anagrams {

    void main() {
        areAnagrams("abcz", "bcaz");
    }

    public boolean areAnagrams(String str1, String str2) {
        // Quick check for obvious non-anagrams
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        // Convert to lowercase for case-insensitive comparison
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Count character frequencies
        int[] charCount = new int[26]; // Assuming only lowercase letters
        // O(n)
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++;
            charCount[str2.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
