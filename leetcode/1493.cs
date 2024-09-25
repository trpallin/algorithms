public class Solution {
    private bool hasZero(int[] nums) {
        for (int i = 0; i < nums.Length; i++) {
            if (nums[i] == 0) {
                return true;
            }
        }
        return false;
    }
    public int LongestSubarray(int[] nums) {
        if (!hasZero(nums)) {
            return nums.Length - 1;
        }
        int length = 0, maxLength = 0, lastZero = -1;
        for (int i = 0; i < nums.Length; i++) {
            if (nums[i] == 0) {
                length = i - lastZero - 1;
                lastZero = i;
            } else {
                length++;
            }
            maxLength = Math.Max(maxLength, length);
        }
        return maxLength;
    }
}