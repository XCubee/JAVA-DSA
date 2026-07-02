import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        // dist[i][j] will store the minimum health cost to reach cell (i, j)
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Deque<int[]> deque = new ArrayDeque<>();
        
        // Base case: Starting cell cost
        dist[0][0] = grid.get(0).get(0);
        deque.offerFirst(new int[]{0, 0});
        
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0];
            int c = curr[1];
            
            // Early exit if we reached the destination
            if (r == m - 1 && c == n - 1) {
                break;
            }
            
            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int weight = grid.get(nr).get(nc);
                    if (dist[r][c] + weight < dist[nr][nc]) {
                        dist[nr][nc] = dist[r][c] + weight;
                        
                        if (weight == 0) {
                            deque.offerFirst(new int[]{nr, nc});
                        } else {
                            deque.offerLast(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        
        // We need remaining health >= 1, meaning health lost must be <= health - 1
        return dist[m - 1][n - 1] < health;
    }
}