
// Problem: Group strings that are anagrams of each other.
void main() {
    var result = groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
    System.out.println(result);
}

public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
        return new ArrayList<>();
    }

    Map<String, List<String>> anagramGroups = new HashMap<>();

    for (String str : strs) {
        // Convert string to char array, sort it, and convert back to string
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sortedStr = new String(chars);

        // Get or create list for this anagram signature
        if (!anagramGroups.containsKey(sortedStr)) {
            anagramGroups.put(sortedStr, new ArrayList<>());
        }

        // Add string to its anagram group
        anagramGroups.get(sortedStr).add(str);
    }

    // Return all anagram groups
    return new ArrayList<>(anagramGroups.values());
}
