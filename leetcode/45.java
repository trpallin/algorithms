class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int jumps = 0;
        int farthest = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; ++i) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == currMax) {
                jumps++;
                currMax = farthest;
                if (currMax >= nums.length - 1) {
                    break;
                }
            }
            
        }

        return jumps;
    }
}