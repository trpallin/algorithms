class Solution {
    private void dfs(int[][] isConnected, int node, boolean[] visited) {
        visited[node] = true;
        int[] nodes = isConnected[node];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == 1 && !visited[i]) {
                dfs(isConnected, i, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int i = 0;
        int count = 0;
        while (i < n) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, i, visited);
            }
            i++;
        }
        return count;
    }
}