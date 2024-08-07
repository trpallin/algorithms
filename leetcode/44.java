class Solution {
    // There is also an O(m*n) time and O(1) space solution.
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-1];
            }
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char x = s.charAt(i-1);
                char y = p.charAt(j-1);

                if (y == '*') {
                    dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1];
                } else if (y == '?' || x == y) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[m][n];
    }
}