class Solution {
    private int calculateMaxArea(int[] heights) {
        Stack<Integer> shortHeights = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; ++i) {
            int currHeight = i == heights.length ? 0 : heights[i];

            while (!shortHeights.isEmpty() && currHeight < heights[shortHeights.peek()]) {
                int idx = shortHeights.pop();
                int height = heights[idx];
                int width = shortHeights.isEmpty() ? i : i - shortHeights.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            shortHeights.push(i);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] heights = new int[col];
        int maxArea = 0;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, calculateMaxArea(heights));
        }

        return maxArea;
    }
}