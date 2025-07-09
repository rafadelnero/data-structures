
void main() {
    findMissingNumber(new int[] { 1, 2, 3, 4, 5});
}

public int findMissingNumber(int[] nums) {
    // Handle edge case
    if (nums == null || nums.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty or null");
    }

    int n = nums.length;
    int expectedSum = n * (n + 1) / 2; // Sum of numbers from 0 to n
    int actualSum = 0;

    // Calculate actual sum of array
    for (int num : nums) {
        actualSum += num;
    }

    // The difference is the missing number
    return expectedSum - actualSum;
}
