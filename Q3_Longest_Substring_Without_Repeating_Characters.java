import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3_Longest_Substring_Without_Repeating_Characters {
    // Brute Force approach: Check all substrings to see if they have unique characters.
    public static int lengthOfLongestSubstring_BruteForce(String s) {
        int n = s.length();
        int maxLen = 0;
        // Iterate through all possible starting points of the substring.
        for (int i = 0; i < n; i++) {
            // Iterate through all possible ending points of the substring.
            for (int j = i; j < n; j++) {
                // Check if the current substring has unique characters.
                if (hasUniqueCharacters(s, i, j)) {
                    maxLen = Math.max(maxLen, j - i + 1); // Update the maximum length if unique.
                }
            }
        }
        return maxLen;
    }

    // Helper method to check if the substring s[start...end] has unique characters.
    public static boolean hasUniqueCharacters(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) return false; // Found a duplicate character.
            set.add(ch);
        }
        return true; // All characters are unique.
    }

    public static int lengthOfLongestSubstring_Optimal(String s) {
        int left = 0, right = 0, maxLen = 0; // Initialize variables for the sliding window.
        Set<Character> set = new HashSet<>(); // Set to store unique characters in the current window.

        while (right < s.length()) { // Iterate through the string.
            if (!set.contains(s.charAt(right))) { // If the current character is not in the set.
                set.add(s.charAt(right)); // Add the current character to the set.
                maxLen = Math.max(maxLen, right - left + 1); // Update the maximum length.
                right++; // Move the right pointer to the right.
            } else { // If the current character is in the set.
                // Remove from the left until the duplicate at 'right' is removed.
                set.remove(s.charAt(left));
                left++; // Move the left pointer to the right.
            }
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring_MostOptimal(String s) {
        int n = s.length(), maxlen = 0; // Get the length of the string and initialize the result variable.
        Map<Character, Integer> map = new HashMap<>(); // Map to store the next possible start index for the window.

        for (int left = 0, right = 0; right < n; right++) { // Iterate over the string.
            char ch = s.charAt(right);
            if (map.containsKey(ch)) { // If the character is present in the map, update 'left' to the next valid start.
                left = Math.max(left, map.get(ch)); // Update 'left' to the next valid start.
            }
            maxlen = Math.max(maxlen, right - left + 1); // Update the maximum length.
            map.put(ch, right + 1); // Store the next possible valid start index for the window.
        }
        return maxlen; // Return the result.
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Brute Force: " + lengthOfLongestSubstring_BruteForce(s));
        System.out.println("Optimal: " + lengthOfLongestSubstring_Optimal(s));
        System.out.println("Most Optimal: " + lengthOfLongestSubstring_MostOptimal(s));
    }
}