
public void main() {
    // 1. String creation
    String str1 = "Duke"; // String literal - stored in string pool
    String str2 = "Duke"; // Reuses the same object from string pool
    String str3 = new String("Duke"); // Forces creation of new object in heap

    // 2. String immutability
    String mascot = "Duke";
    mascot.concat(" Java"); // This creates a new string but doesn't change 'mascot'
    System.out.println(mascot); // Still prints "Duke"

    mascot = mascot.concat(" Java"); // Assignment required to capture the new string
    System.out.println(mascot); // Now prints "Duke Java"

    // 3. String comparison
    String s1 = "JavaChallengers";
    String s2 = "JavaChallengers";
    String s3 = new String("JavaChallengers");

    System.out.println(s1 == s2); // true (same reference from string pool)
    System.out.println(s1 == s3); // false (different objects)
    System.out.println(s1.equals(s3)); // true (same content)

    // 4. Common String methods
    String text = "Duke loves Java";
    System.out.println(text.length()); // 15
    System.out.println(text.charAt(0)); // D
    System.out.println(text.substring(0, 4)); // Duke
    System.out.println(text.indexOf("loves")); // 5
    System.out.println(text.contains("Java")); // true
    System.out.println(text.toLowerCase()); // duke loves java
    System.out.println(text.replace('a', 'o')); // Duke loves Jovo

    // 5. String concatenation
    String prefix = "Java";
    String suffix = "Challengers";
    String fullName = prefix + " " + suffix; // Using + operator
    System.out.println(fullName); // Java Challengers

    // 6. Performance considerations - StringBuilder
    StringBuilder sb = new StringBuilder();
    sb.append("Duke");
    for (int i = 0; i < 10; i++) {
        sb.append(" loves Java ").append(i); // Efficient for multiple concatenations
    }
    String result = sb.toString();

    // 7. String formatting
    String formatted = String.format("Mascot: %s, Challengers: %d", "Duke", 100);
    System.out.println(formatted); // Mascot: Duke, Challengers: 100

    // 8. String interning
    String s4 = "javaChallengers";
    String s5 = new String("javaChallengers").intern(); // Forces string to the pool
    System.out.println(s4 == s5); // true after interning

    // 9. String splitting
    String courses = "Java,Kotlin,JVM,Duke";
    String[] courseArray = courses.split(",");
    System.out.println(courseArray[3]); // Duke
}
