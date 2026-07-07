import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // 1. Sort by start times safely (avoids subtraction overflow)
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Create a list to hold our merged intervals
        List<int[]> mergedBalloons = new ArrayList<>();
        
        // Put the first balloon in to start the process
        mergedBalloons.add(points[0]);

        for (int i = 1; i < points.length; i++) {
            int[] nextBalloon = points[i];
            // Grab the last interval we added to our merged list
            int[] currentArrowZone = mergedBalloons.get(mergedBalloons.size() - 1);

            // If they overlap, merge them by shrinking the arrow zone to the shared space
            if (nextBalloon[0] <= currentArrowZone[1]) {
                currentArrowZone[1] = Math.min(currentArrowZone[1], nextBalloon[1]);
            } else {
                // No overlap! Add it as a completely new separate interval zone
                mergedBalloons.add(nextBalloon);
            }
        }

        // 3. The number of arrows needed is exactly the number of merged interval zones left!
        return mergedBalloons.size();
    }
}