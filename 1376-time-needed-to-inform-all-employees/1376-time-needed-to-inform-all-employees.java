import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Step 1: Build the tree (adjacency list of manager -> subordinates)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adj.get(manager[i]).add(i);
            }
        }
        
        // Step 2: BFS Initialization
        // queue stores pairs of {employeeID, timeTakenToReachThisEmployee}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{headID, 0});
        
        int maxTime = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currEmployee = curr[0];
            int timeAccumulated = curr[1];
            
            maxTime = Math.max(maxTime, timeAccumulated);
            
            // Push all direct subordinates to the queue
            for (int subordinate : adj.get(currEmployee)) {
                queue.offer(new int[]{
                    subordinate, 
                    timeAccumulated + informTime[currEmployee]
                });
            }
        }
        
        return maxTime;
    }
}