
void main() {
    var result = haveSameElements(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3, 4, 5 });
    System.out.println(result);
}

public boolean haveSameElements(int[] arr1, int[] arr2) {
    if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
        return false;
    }

    // Count elements in first array
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int num : arr1) {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    // Check elements in second array
    for (int num : arr2) {
        // If element doesn't exist or count becomes negative, arrays differ
        if (!countMap.containsKey(num) || countMap.get(num) <= 0) {
            return false;
        }

        // Decrement count
        countMap.put(num, countMap.get(num) - 1);
    }

    // All counts should be zero if arrays have same elements
    for (int count : countMap.values()) {
        if (count != 0) {
            return false;
        }
    }

    return true;
}
