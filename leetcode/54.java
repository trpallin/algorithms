class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int repeats = m > n ? n * 2 : m * 2 - 1;
        List<Integer> ans = new ArrayList<>();

        if (n == 1) {
            for (int i = 0; i < m; ++i) {
                ans.add(matrix[i][0]);
            }
            return ans;
        }

        for (int i = 0; i < repeats; ++i) {
            if ((i & 1) == 0) {
                if ((i & 2) == 0) {
                    int row = i / 4;
                    int startCol = row;
                    int endCol = n - 1 - row;
                    for (int j = startCol; j <= endCol; ++j) {
                        ans.add(matrix[row][j]);
                    }
                } else {
                    int row = m - 1 - i / 4;
                    int startCol = i / 4;
                    int endCol = n - 2 - i / 4;
                    for (int j = endCol; j >= startCol; --j) {
                        ans.add(matrix[row][j]);
                    }
                }
            } else {
                if ((i & 2) == 0) {
                    int col = n - 1 - i / 4;
                    int startRow = i / 4 + 1;
                    int endRow = m - 1 - i / 4;
                    for (int j = startRow; j <= endRow; ++j) {
                        ans.add(matrix[j][col]);
                    }
                } else {
                    int col = i / 4;
                    int startRow = i / 4 + 1;
                    int endRow = m - 2 - i / 4;
                    for (int j = endRow; j >= startRow; --j) {
                        ans.add(matrix[j][col]);
                    }
                }
            }
        }
        return ans;
    }
}