class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n - 1] = s.charAt(n-1) != '0' ? 1 : 0;
        dp[n] = 1;
        for (int i = n-2; i >= 0; --i) {
            char first = s.charAt(i);
            char second = s.charAt(i+1);
            if (first != '0') {
                dp[i] += dp[i+1];
            }
            if (first == '1' || (first == '2' && second < '7')) {
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
}