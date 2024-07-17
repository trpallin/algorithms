class Solution {
    private void solve(int[] nums, boolean[] added, List<List<Integer>> ans, List<Integer> cur) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!added[i]) {
                cur.add(nums[i]);
                added[i] = true;
                solve(nums, added, ans, cur);
                added[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        boolean[] added = new boolean[nums.length];
        solve(nums, added, ans, arr);

        return ans;
    }
}