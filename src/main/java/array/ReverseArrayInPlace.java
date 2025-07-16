
// Problem: Reverse the elements of an array without using extra space.
void main() {
    reverseArray(new int[] { 1, 2, 3, 4, 5 });
}

public void reverseArray(int[] nums) {
    // Handle edge case
    if (nums == null || nums.length <= 1) {
        return; // No need to reverse
    }

    // Two-pointer approach
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
        // Swap elements at left and right pointers
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        // Move pointers towards the center
        left++;
        right--;
    }
    System.out.println(nums);
}
