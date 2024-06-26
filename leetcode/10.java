class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            char c = p.charAt(i-1);
            if (c == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char sChar = s.charAt(i-1);
                char pChar = p.charAt(j-1);

                if (sChar == pChar || pChar == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i][j-2] || (dp[i-1][j] && (sChar == p.charAt(j-2) || p.charAt(j-2) == '.'));
                }
            }
        }

        return dp[m][n];
    }
}