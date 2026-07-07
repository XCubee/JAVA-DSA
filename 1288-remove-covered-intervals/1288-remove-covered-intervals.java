import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 1. Sort by start ascending, then by end descending
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // End time descending
            }
            return a[0] - b[0]; // Start time ascending
        });
        
        int remainingCount = 0;
        int maxEnd = 0;
        
        // 2. Single pass to find covered intervals
        for (int[] interval : intervals) {
            // If the current interval's end is past our maxEnd, it's NOT covered!
            if (interval[1] > maxEnd) {
                remainingCount++;
                maxEnd = interval[1]; // Update the boundary
            }
            // If interval[1] <= maxEnd, it is completely swallowed, so we ignore it.
        }
        
        return remainingCount;
    }
}