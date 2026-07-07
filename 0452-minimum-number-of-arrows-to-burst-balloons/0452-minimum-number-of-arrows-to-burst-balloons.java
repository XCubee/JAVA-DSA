class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort by end point using Integer.compare to avoid overflow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // If this balloon starts after the current arrow position,
            // it needs a new arrow
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
}