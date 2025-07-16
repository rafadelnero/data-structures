
// Given an array containing n distinct numbers taken from 0, 1, 2, ...,
// n, find the one number that is missing from the array.
void main() {
    var result = findMissingNumber(new int[] { 1, 4, 5});
    System.out.println(result);
}

public int findMissingNumber(int[] nums) {
    // Handle edge case
    if (nums == null || nums.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty or null");
    }

    // Find min and max to determine the range
    int min = nums[0];
    int max = nums[0];

    for (int num : nums) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }

    // Create a boolean array to mark present numbers
    boolean[] present = new boolean[max - min + 1];

    // Mark all numbers in the array as present
    for (int num : nums) {
        present[num - min] = true;
    }

    // Find the first missing number
    for (int i = 0; i < present.length; i++) {
        if (!present[i]) {
            return i + min;
        }
    }

    // If no number is missing (shouldn't happen given the problem statement)
    throw new IllegalArgumentException("No missing number found");
}

public int findMissingNumberMathFormula(int[] nums) {
    // Handle edge case
    if (nums == null || nums.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty or null");
    }

    // Find min and max to determine the range
    int min = nums[0];
    int max = nums[0];
    int actualSum = 0;

    for (int num : nums) {
        min = Math.min(min, num);
        max = Math.max(max, num);
        actualSum += num;
    }

    // Expected sum for a consecutive sequence from min to max
    int expectedSum = (max - min + 1) * (min + max) / 2;

    // The difference is the missing number
    return expectedSum - actualSum;
}

public int findMissingNumberXor(int[] nums) {
    // Handle edge case
    if (nums == null || nums.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty or null");
    }

    // Find min and max to determine the range
    int min = nums[0];
    int max = nums[0];

    for (int num : nums) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }

    // XOR all numbers in the expected range
    int xorExpected = 0;
    for (int i = min; i <= max; i++) {
        xorExpected ^= i;
    }

    // XOR all numbers in the actual array
    int xorActual = 0;
    for (int num : nums) {
        xorActual ^= num;
    }

    // The XOR of these two results will give us the missing number
    return xorExpected ^ xorActual;
}

