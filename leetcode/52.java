class Solution {
    private List<String> makeBoardWithQueens(int[] queenCols) {
        List<String> board = new ArrayList<>();
        int n = queenCols.length;
        for (int queenCol : queenCols) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                if (i == queenCol) {
                    row.append("Q");
                } else {
                    row.append(".");
                }
            }
            board.add(row.toString());
        }
        return board;
    }

    private void solve(int lefts, int rights, int cols, int[] queenCols, List<List<String>> ans, int cur, int n) {
        if (cur == n) {
            ans.add(makeBoardWithQueens(queenCols));
            return;
        }
        int availablePositions = ((1 << n) - 1) & ~(lefts | cols | rights);
        while (availablePositions != 0) {
            int position = availablePositions & -availablePositions;
            availablePositions &= availablePositions - 1;
            int col = Integer.bitCount(position - 1);
            queenCols[cur] = col;
            solve((lefts | position) << 1, (rights | position) >> 1, cols | position, queenCols, ans, cur + 1, n);
        }
    }

    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queenCols = new int[n];
        solve(0, 0, 0, queenCols, ans, 0, n);
        return ans.size();
    }
}