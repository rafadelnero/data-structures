
void main() {
    removeDuplicates(new int[] { 1, 1, 2 });
}

public int removeDuplicates(int[] nums) {
    // Handle edge cases
    if (nums == null) {
        return 0;
    }
    if (nums.length <= 1) {
        return nums.length;
    }

    // Use two pointers
    int uniqueIndex = 1; // Start from second element

    for (int i = 1; i < nums.length; i++) {
        // If current element is different from previous element
        if (nums[i] != nums[i - 1]) {
            // Add it to unique elements section
            nums[uniqueIndex] = nums[i];
            uniqueIndex++;
        }
    }

    return uniqueIndex; // New length of array without duplicates
}
