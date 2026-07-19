import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Only start BFS if we hit an unvisited piece of land
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, rows, cols);
                }
            }
        }
        return count;
    }

    // FIXED: Changed parameter type from int[][] to char[][]
    private void bfs(char[][] grid, int row, int col, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        grid[row][col] = '0'; // Mark as visited
        queue.offer(new int[]{row, col});
        
        // FIXED: Added missing array bracket dimensions and fixed the direction vectors
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); // FIXED: Added missing ()

            for (int[] dir : directions) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                
                // FIXED: Changed boundaries to >= 0 instead of > 0
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0'; // Mark as visited immediately before pushing to queue
                    queue.offer(new int[]{newRow, newCol}); // FIXED: Corrected array initialization syntax
                }
            }
        }
    }
}