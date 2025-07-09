
// Problem: Determine if a string is a rotation of another string (e.g., "waterbottle" is a rotation of "erbottlewat").
void main() {
    isRotation("waterbottle", "erbottlewat");
}

public boolean isRotation(String s1, String s2) {
    // Check if strings are equal length and not empty
    if (s1 == null || s2 == null || s1.length() != s2.length() || s1.length() == 0) {
        return false;
    }

    // Try all possible rotation points
    int len = s1.length();// O(n)2
    for (int i = 0; i < len; i++) {
        boolean isMatch = true;

        // Check if s2 matches this rotation of s1
        for (int j = 0; j < len; j++) {
            if (s1.charAt((i + j) % len) != s2.charAt(j)) {
                isMatch = false;
                break;
            }
        }

        if (isMatch) {
            return true;
        }
    }

    return false;
}