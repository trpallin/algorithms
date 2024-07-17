class Solution {
    private void solve(int[] nums, boolean[] visited, List<List<Integer>> ans, List<Integer> cur) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList(cur));
            return;
        }
        int lastNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == lastNum) continue;
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                solve(nums, visited, ans, cur);
                cur.remove(cur.size() - 1);
                visited[i] = false;
                lastNum = nums[i];
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        solve(nums, visited, ans, cur);
        return ans;
    }
}