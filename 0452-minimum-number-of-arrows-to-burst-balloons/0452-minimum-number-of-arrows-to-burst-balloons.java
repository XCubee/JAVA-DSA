import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // 1. Sort by start times safely
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Initialize the list with the first whole balloon array
        List<int[]> mergedList = new ArrayList<>();
        mergedList.add(points[0]); 

        // 3. Loop through the rest of the balloons
        for (int i = 1; i < points.length; i++) {
            int[] nextBalloon = points[i]; // This fixes your undefined 'nextNode'
            
            // Grab the last tracked arrow zone from your list
            int[] prevNode = mergedList.get(mergedList.size() - 1); 

            // If the next balloon starts before or exactly when the current arrow zone ends
            if (nextBalloon[0] <= prevNode[1]) {
                // They OVERLAP! Shrink the zone to the shared intersection space
                prevNode[1] = Math.min(prevNode[1], nextBalloon[1]);
            } else {
                // NO OVERLAP! We need a completely separate arrow zone
                mergedList.add(nextBalloon);
            }
        }

        // The number of arrows needed is the total size of your distinct merged zones
        return mergedList.size();
    }
}