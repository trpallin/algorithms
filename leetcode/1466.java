class Solution {
    private int numReorder = 0;

    private void dfs(List<List<Integer>> incomingList, List<List<Integer>> outgoingList, int cur, boolean[] visited) {
        visited[cur] = true;
        List<Integer> incomings = incomingList.get(cur);
        List<Integer> outgoings = outgoingList.get(cur);

        for (int node : incomings) {
            if (!visited[node]) {
                dfs(incomingList, outgoingList, node, visited);
            }
        }
        for (int node : outgoings) {
            if (!visited[node]) {
                numReorder++;
                dfs(incomingList, outgoingList, node, visited);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> incomingList = new ArrayList<>();
        List<List<Integer>> outgoingList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            incomingList.add(new LinkedList<Integer>());
            outgoingList.add(new LinkedList<Integer>());
        }
        boolean[] visited = new boolean[n];
        for (int[] connection : connections) {
            incomingList.get(connection[1]).add(connection[0]);
            outgoingList.get(connection[0]).add(connection[1]);
        }
        dfs(incomingList, outgoingList, 0, visited);
        return numReorder;
    }
}