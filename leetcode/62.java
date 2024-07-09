class Solution {
    int comb(int n, int k, int[][] cache) {
        if (k == 0) return 1;
        if (k == 1) return n;
        if (k > n/2) return comb(n, n-k, cache);
        return cache[n][k] == 0 ? cache[n][k] = comb(n-1, k-1, cache) + comb(n-1, k, cache) : cache[n][k];
    }

    public int uniquePaths(int m, int n) {
        int minCol = Math.min(m, n);
        int[][] cache = new int[m+n-1][minCol];
        return comb(m+n-2, minCol-1, cache);
    }
}