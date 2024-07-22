class Solution {
    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
    
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int count = 1;
        int row = 0;
        int col = 0;
        Direction dir = Direction.RIGHT;
        while (count <= n * n) {
            ans[row][col] = count++;
            if (dir == Direction.UP) {
                if (row == col + 1) {
                    dir = Direction.RIGHT;
                    col++;
                } else {
                    row--;
                }
            } else if (dir == Direction.DOWN) {
                if (row == col) {
                    dir = Direction.LEFT;
                    col--;
                } else {
                    row++;
                }
            } else if (dir == Direction.LEFT) {
                if (col == n - 1 - row) {
                    dir = Direction.UP;
                    row--;
                } else {
                    col--;
                }
            } else {
                if (col == n - 1 - row) {
                    dir = Direction.DOWN;
                    row++;
                } else {
                    col++;
                }
            }
        }
        return ans;
    }
}