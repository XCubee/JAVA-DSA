import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 1. Sort: Ascending by start, Descending by end if starts are equal
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending by end
            }
            return a[0] - b[0]; // Ascending by start
        });

        int remainingCount = intervals.length;
        int maxEnd = 0;

        // 2. Traverse and find covered intervals
        for (int[] interval : intervals) {
            int currentEnd = interval[1];
            
            // If the current interval's end is <= maxEnd, it is fully covered
            if (currentEnd <= maxEnd) {
                remainingCount--;
            } else {
                // Otherwise, it extends further, update our maxEnd boundary
                maxEnd = currentEnd;
            }
        }

        return remainingCount;
    }
}