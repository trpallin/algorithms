class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        for (int i = 1; i < n; i++) {
            int a = i - 2 >= 0 ? nums[i - 2] : 0;
            nums[i] = Math.max(a + nums[i], nums[i - 1]);
        }
        return Math.max(nums[n - 2], nums[n - 1]);
    }
}