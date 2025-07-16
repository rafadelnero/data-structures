
/*
Given a sorted array of integers, remove the duplicates in-place such that each element appears
only once and return the new length.
Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements should be kept the same.
 */
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
