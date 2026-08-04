class Solution {
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;

        String highPair = x >= y ? "ab" : "ba";
        String lowPair = x >= y ? "ba" : "ab";
        int highPoints = Math.max(x, y);
        int lowPoints = Math.min(x, y);

        // First pass: remove high scoring pairs
        StringBuilder stack1 = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = stack1.length();
            if (len > 0 && stack1.charAt(len - 1) == highPair.charAt(0) && c == highPair.charAt(1)) {
                stack1.deleteCharAt(len - 1); // "Pop" matching pair
                totalScore += highPoints;
            } else {
                stack1.append(c);
            }
        }

        // Second pass: remove low scoring pairs from remaining string
        StringBuilder stack2 = new StringBuilder();
        for (int i = 0; i < stack1.length(); i++) {
            char c = stack1.charAt(i);
            int len = stack2.length();
            if (len > 0 && stack2.charAt(len - 1) == lowPair.charAt(0) && c == lowPair.charAt(1)) {
                stack2.deleteCharAt(len - 1); // "Pop" matching pair
                totalScore += lowPoints;
            } else {
                stack2.append(c);
            }
        }

        return totalScore;
    }
}