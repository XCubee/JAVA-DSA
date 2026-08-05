class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int m = s.length();
        
        // dp[i][ch] = index of next occurrence of 'ch' at or after index i in t
        int[][] dp = new int[n + 1][26];
        
        // Base case: past the end of string t, no characters exist
        for (int c = 0; c < 26; c++) {
            dp[n][c] = -1;
        }
        
        // Build DP matrix from right to left
        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c < 26; c++) {
                dp[i][c] = dp[i + 1][c];
            }
            dp[i][t.charAt(i) - 'a'] = i;
        }
        
        // Query string s using the precomputed matrix
        int currPos = 0;
        for (int i = 0; i < m; i++) {
            int charIdx = s.charAt(i) - 'a';
            
            // If character does not exist at or after current position
            if (dp[currPos][charIdx] == -1) {
                return false;
            }
            
            // Jump directly to the next position after the match
            currPos = dp[currPos][charIdx] + 1;
        }
        
        return true;
    }
}