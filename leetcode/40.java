class Solution {
    private void solve(int[] candidates, int curIdx, List<List<Integer>> ans, List<Integer> curList, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(curList));
            return;
        }
        int n = candidates.length;
        
        for (int i = curIdx; i < n; ++i) {
            int num = candidates[i];
            if (i > curIdx && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (num > target) {
                break;
            }
            curList.add(num);
            solve(candidates, i + 1, ans, curList, target - num);
            curList.remove(curList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, ans, curList, target);
        return ans;
    }
}