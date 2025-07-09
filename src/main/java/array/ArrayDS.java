
void main() {
    arrayTimeComplexity();
}

void arrayTimeComplexity() {
    // Array initialization
    int[] javaScores = {95, 87, 92, 78, 88};
    String[] javaMascots = {"Duke", "Java Duke", "JavaFX Duke", "NetBeans Duke", "OpenJDK Duke"};

    // 1. ACCESS - O(1) time complexity
    System.out.println("------ ACCESS: O(1) ------");
    // Accessing by index is constant time regardless of array size
    System.out.println("First mascot: " + javaMascots[0]); // O(1)
    System.out.println("Last score: " + javaScores[javaScores.length-1]); // O(1)

    // 2. SEARCH (unsorted array) - O(n) time complexity
    System.out.println("\n------ SEARCH (unsorted): O(n) ------");
    int searchScore = 92;
    // Linear search must check each element in worst case
    for (int i = 0; i < javaScores.length; i++) { // O(n)
        if (javaScores[i] == searchScore) {
            System.out.println("Found score " + searchScore + " at index " + i);
            break;
        }
    }

    // 3. SEARCH (sorted array) - O(log n) time complexity
    System.out.println("\n------ SEARCH (sorted): O(log n) ------");
    java.util.Arrays.sort(javaScores); // O(n log n) - sorting first
    int index = java.util.Arrays.binarySearch(javaScores, 92); // O(log n)
    System.out.println("Binary search found score 92 at index: " + index);

    // 4. INSERTION at end (with space) - O(1) time complexity
    System.out.println("\n------ INSERTION (with space): O(1) or O(n) ------");
    // When we have pre-allocated array with space
    String[] dukeVersions = new String[10]; // Capacity for 10 items
    int count = 0;

    // Adding to end when space exists - O(1)
    dukeVersions[count++] = "Original Duke"; // O(1)
    dukeVersions[count++] = "Coffee Duke";   // O(1)
    System.out.println("Added to end with available space: O(1)");

    // 5. INSERTION in middle - O(n) time complexity
    String newDuke = "Jumping Duke";
    int insertPos = 1;

    // Need to shift elements to make room
    for (int i = count; i > insertPos; i--) { // O(n) in worst case
        dukeVersions[i] = dukeVersions[i-1];
    }
    dukeVersions[insertPos] = newDuke;
    count++;
    System.out.println("Inserted in middle with shifting: O(n)");

    // 6. DELETION from middle - O(n) time complexity
    System.out.println("\n------ DELETION from middle: O(n) ------");
    int deletePos = 1;

    // Need to shift elements to close the gap
    for (int i = deletePos; i < count-1; i++) { // O(n) in worst case
        dukeVersions[i] = dukeVersions[i+1];
    }
    dukeVersions[count-1] = null; // Clear the last position
    count--;
    System.out.println("Deleted from middle with shifting: O(n)");

    // 7. DELETION from end - O(1) time complexity
    System.out.println("\n------ DELETION from end: O(1) ------");
    // Simply decrement count and/or set to null
    dukeVersions[count-1] = null; // O(1)
    count--;
    System.out.println("Deleted from end: O(1)");

    // 8. ITERATION - O(n) time complexity
    System.out.println("\n------ ITERATION: O(n) ------");
    for (int i = 0; i < count; i++) { // O(n)
        if (dukeVersions[i] != null) {
            System.out.println("Duke version " + i + ": " + dukeVersions[i]);
        }
    }

    // 9. RESIZE (creating new array) - O(n) time complexity
    System.out.println("\n------ RESIZE: O(n) ------");
    int[] oldScores = {85, 90, 95};
    int[] newScores = new int[oldScores.length * 2]; // Double the size

    // Copy all elements to new array
    for (int i = 0; i < oldScores.length; i++) { // O(n)
        newScores[i] = oldScores[i];
    }
    System.out.println("Resized array from " + oldScores.length +
            " to " + newScores.length + " elements: O(n)");

    // 10. UPDATE - O(1) time complexity
    System.out.println("\n------ UPDATE: O(1) ------");
    javaScores[2] = 99; // O(1)
    System.out.println("Updated score at index 2: O(1)");
}


