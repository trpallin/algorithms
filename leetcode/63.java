class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] routes = new int[row+1][col+1];
        routes[0][1] = 1;
        for (int i = 1; i <= row; ++i) {
            for (int j = 1; j <= col; ++j) {
                if (obstacleGrid[i-1][j-1] == 0)
                    routes[i][j] += routes[i-1][j] + routes[i][j-1];
            }
        }
        return routes[row][col];
    }
}