
public static void main(String[] args) {
    System.out.println("=== Normal HashMap Performance ===");
    measureNormalHashMapPerformance(10000);

    System.out.println("\n=== HashMap with Collisions Performance ===");
    measureCollisionHashMapPerformance(10000);
}

// Measures performance with good hash distribution
public static void measureNormalHashMapPerformance(int size) {
    Map<GoodHashObject, Integer> map = new HashMap<>();

    // Measure insertion time
    long startTime = System.nanoTime();
    for (int i = 0; i < size; i++) {
        map.put(new GoodHashObject(i), i);
    }
    long endTime = System.nanoTime();
    System.out.printf("Insertion time for %d elements: %.2f ms\n",
            size, (endTime - startTime) / 1_000_000.0);

    // Measure lookup time for random elements
    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
        map.get(new GoodHashObject(i));
    }
    endTime = System.nanoTime();
    System.out.printf("Lookup time for 1000 elements: %.2f ms\n",
            (endTime - startTime) / 1_000_000.0);
}

// Measures performance with hash collisions
public static void measureCollisionHashMapPerformance(int size) {
    Map<BadHashObject, Integer> map = new HashMap<>();

    // Measure insertion time with collisions
    long startTime = System.nanoTime();
    for (int i = 0; i < size; i++) {
        map.put(new BadHashObject(i), i);
    }
    long endTime = System.nanoTime();
    System.out.printf("Insertion time for %d elements: %.2f ms\n",
            size, (endTime - startTime) / 1_000_000.0);

    // Measure lookup time with collisions
    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
        map.get(new BadHashObject(i));
    }
    endTime = System.nanoTime();
    System.out.printf("Lookup time for 1000 elements: %.2f ms\n",
            (endTime - startTime) / 1_000_000.0);
}

// Class with good hash distribution
static class GoodHashObject {
    private int value;

    public GoodHashObject(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value; // Good distribution for integers
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GoodHashObject that = (GoodHashObject) obj;
        return value == that.value;
    }
}

// Class with deliberate hash collisions
static class BadHashObject {
    private int value;

    public BadHashObject(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        // All objects hash to the same bucket
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BadHashObject that = (BadHashObject) obj;
        return value == that.value;
    }
}
