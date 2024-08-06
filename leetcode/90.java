class Solution {
    private void solve(int[] nums, int n, List<Integer> cur, List<List<Integer>> result) {
        result.add(new ArrayList<>(cur));
        for (int i = n; i < nums.length; i++) {
            if (i > n && nums[i] == nums[i-1]) continue;
            cur.add(nums[i]);
            solve(nums, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, cur, result);
        return result;
    }
}