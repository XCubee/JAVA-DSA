class Solution {
    public int maximumGain(String s, int x, int y) {
        int aCount = 0;
        int bCount = 0;
        int totalScore = 0;

        // Determine priority
        char first = x >= y ? 'a' : 'b';
        char second = x >= y ? 'b' : 'a';
        int highPoints = Math.max(x, y);
        int lowPoints = Math.min(x, y);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == first) {
                aCount++;
            } else if (c == second) {
                if (aCount > 0) {
                    // We found a high-value pair! (e.g., 'a' followed by 'b')
                    aCount--;
                    totalScore += highPoints;
                } else {
                    // No matching 'first' character available, buffer this 'second'
                    bCount++;
                }
            } else {
                // Non-'a'/'b' character acts as a separator.
                // Clear out remaining low-value pairs for this block.
                totalScore += Math.min(aCount, bCount) * lowPoints;
                aCount = 0;
                bCount = 0;
            }
        }

        // Process any remaining counts at the end of the string
        totalScore += Math.min(aCount, bCount) * lowPoints;

        return totalScore;
    }
}