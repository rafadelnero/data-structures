
// Problem: Find two numbers (indexes) in an array that add up to a target value.
void main() {
    var result = twoSum(new int[] { 2, 7, 11, 15 }, 9);
    System.out.println(Arrays.toString(result));
}

public int[] twoSum(int[] nums, int target) {
    // Create a map to store values and their indices
    Map<Integer, Integer> numMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];

        // Check if complement exists in map
        if (numMap.containsKey(complement)) {
            return new int[] {numMap.get(complement), i};
        }

        // Add current number and its index to map
        numMap.put(nums[i], i);
    }

    // No solution found
    return new int[] {-1, -1};
}
