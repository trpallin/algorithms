class Solution {
    private void solve(int[] candidates, List<List<Integer>> res, int curr, List<Integer> nums, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = curr; i < candidates.length; ++i) {
            nums.add(candidates[i]);
            solve(candidates, res, i, nums, target - candidates[i]);
            nums.remove(nums.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, res, 0, new ArrayList<>(), target);
        return res;
    }
}