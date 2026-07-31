import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        // Step 1: Count frequency of each letter
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Sort frequencies in ascending order
        Arrays.sort(freq);

        int totalPushes = 0;

        // Step 3: Assign positions starting from the most frequent (end of array)
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break; // No more letters left in word
            
            int distinctCount = 25 - i; // Number of unique characters processed so far
            int pushMultiplier = (distinctCount / 8) + 1; // 1 push for first 8, 2 for next 8, etc.
            
            totalPushes += freq[i] * pushMultiplier;
        }

        return totalPushes;
    }
}