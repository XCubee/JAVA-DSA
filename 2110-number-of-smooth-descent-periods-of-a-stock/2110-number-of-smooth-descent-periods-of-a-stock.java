class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = prices.length;
        long streak = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i-1] - 1) {
                streak++;
                count += streak;
            } else {
                streak = 0;
            }
        }
        
        return count;
    }
}