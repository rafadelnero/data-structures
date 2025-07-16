
// Problem: Find the largest element in an array of integers.
void main() {
    var result = findMax(new int[] { 1, 2, 3, 4, 5 });
    System.out.println(result);
}

public int findMax(int[] nums) {
    // Handle edge case
    if (nums == null || nums.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty or null");
    }

    int max = nums[0]; // Start with first element

    // Iterate through array
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > max) {
            max = nums[i]; // Update max if current element is larger
        }
    }

    return max;
}