class Solution {
    public int maxActiveSectionsAfterTrade(String s) {        
        int totalOnes = 0;
        int maxDelta = 0;

        int prevZero = 0;
        boolean hasOnesInBetween = false;
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            int j = i;

            while (j < s.length() && s.charAt(j) == ch) {
                j++;
            }

            int len = j - i;

            if (ch == '1') {
                totalOnes += len;
                hasOnesInBetween = true; // Mark that we found a 1-block separating zeros
            } else {
                // Only merge zero blocks if there was a block of '1's separating them!
                if (hasOnesInBetween && prevZero > 0) {
                    maxDelta = Math.max(maxDelta, prevZero + len);
                }
                prevZero = len;
                hasOnesInBetween = false; // Reset for the next pair of zero blocks
            }

            i = j;
        }

        return totalOnes + maxDelta;
    }
}