import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {
        // 1. Sort events by START day ascending
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Min-Heap stores the END days of events we can currently attend
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0;
        int n = events.length;
        int maxEventsAttended = 0;
        
        // 2. Iterate day by day
        // Loop runs from day 1 up to day 100,000 (or as long as there are events left)
        for (int d = 1; d <= 100000; d++) {
            
            // Add all events that START on this day 'd' into our heap
            while (i < n && events[i][0] == d) {
                pq.add(events[i][1]); // Only store the end day
                i++;
            }
            
            // Remove any events from the heap that have already EXPIRED before today
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            
            // If we have active events available, attend the one that expires EARLIEST
            if (!pq.isEmpty()) {
                pq.poll(); // Attend it (remove it from pool)
                maxEventsAttended++; // Increment our count
            }
            
            // Optimization: If no more events left to process or attend, we can break early
            if (i >= n && pq.isEmpty()) {
                break;
            }
        }
        
        return maxEventsAttended;
    }
}