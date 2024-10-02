class Solution {
    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        List<Integer> keys = rooms.get(room);
        for (int k : keys) {
            if (!visited[k]) {
                visited[k] = true;
                dfs(rooms, k, visited);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        
        dfs(rooms, 0, visited);

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}