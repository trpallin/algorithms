public class Solution {
    public int PivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.Length; i++) {
            sum += nums[i];
        }
        int sum2 = 0;
        for (int i = 0; i < nums.Length; i++) {
            sum -= nums[i];
            if (sum2 == sum) {
                return i;
            }
            sum2 += nums[i];
        }
        return -1;
    }
}