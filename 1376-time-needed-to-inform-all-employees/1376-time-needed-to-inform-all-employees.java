import java.util.ArrayList;
import java.util.List;

class Solution {
    int maxTime = 0;

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
        
        // Step 2: Start top-down DFS from the head of the company
        dfs(headID, 0, adj, informTime);
        
        return maxTime;
    }
    
    private void dfs(int currEmployee, int timeAccumulated, List<List<Integer>> adj, int[] informTime) {
        // Update the maximum time encountered so far
        maxTime = Math.max(maxTime, timeAccumulated);
        
        // Traverse through all direct subordinates
        for (int subordinate : adj.get(currEmployee)) {
            // Pass down the accumulated time + the current manager's inform time
            dfs(subordinate, timeAccumulated + informTime[currEmployee], adj, informTime);
        }
    }
}