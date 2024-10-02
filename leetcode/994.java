class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenOranges = new LinkedList<>();
        int freshCount = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    rottenOranges.add(new int[] {i, j});
                }
            }
        }
        int minutes = -1;
        if (freshCount == 0) {
            return 0;
        }
        while (!rottenOranges.isEmpty()) {
            int size = rottenOranges.size();

            while (size-- > 0) {
                int[] rottenOrange = rottenOranges.poll();
                int row = rottenOrange[0];
                int col = rottenOrange[1];

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        freshCount--;
                        grid[newRow][newCol] = 2;
                        rottenOranges.add(new int[] {newRow, newCol});
                    }
                }
            }
            minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }
}