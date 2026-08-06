class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;

        char[][] grid = new char[numRows][s.length()];
        int row = 0, col = 0;
        boolean goingDown = true;

        for (int i = 0; i < s.length(); i++) {
            grid[row][col] = s.charAt(i);

            if (goingDown) {
                if (row == numRows - 1) {
                    // Switch to diagonal up-right
                    row--;
                    col++;
                    goingDown = false;
                } else {
                    row++;
                }
            } else {
                if (row == 0) {
                    // Switch back to going down
                    row++;
                    goingDown = true;
                } else {
                    row--;
                    col++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < s.length(); c++) {
                if (grid[r][c] != '\0') {
                    result.append(grid[r][c]);
                }
            }
        }
        return result.toString();
    }
}