class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int removals = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // Overlap: remove the interval that ends later
                removals++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                // No overlap: take this interval
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}