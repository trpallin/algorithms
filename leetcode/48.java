class Solution {
    public void rotateElement(int[][] matrix, int r, int c) {
        int n = matrix.length - 1;
        int temp = matrix[r][c];
        matrix[r][c] = matrix[n-c][r];
        matrix[n-c][r] = matrix[n-r][n-c];
        matrix[n-r][n-c] = matrix[c][n-r];
        matrix[c][n-r] = temp;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int half = n / 2;
        for (int i = 0; i < half; ++i) {
            for (int j = 0; j < half; ++j) {
                rotateElement(matrix, i, j);
            }
        }
        if (n % 2 == 1) {
            for (int i = 0; i < half; ++i) {
                rotateElement(matrix, half, i);
            }
        }
    }
}