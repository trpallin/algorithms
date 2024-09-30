class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> rowMap = new HashMap<>();
        Map<List<Integer>, Integer> colMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = IntStream.of(grid[i]).boxed().toList();
            rowMap.put(list, rowMap.getOrDefault(list, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(grid[j][i]);
            }
            colMap.put(list, colMap.getOrDefault(list, 0) + 1);
        }
        int answer = 0;
        for (List<Integer> key : rowMap.keySet()) {
            if (colMap.containsKey(key)) {
                answer += rowMap.get(key) * colMap.get(key);
            }
        }
        return answer;
    }
}