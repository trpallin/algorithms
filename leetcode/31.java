class Solution {
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 1; i > 0; --i) {
            if (nums[i] > nums[i-1]) {
                int target = i;
                while (target < nums.length && nums[target] > nums[i-1]) {
                    target++;
                }
                if (target == nums.length) {
                    int temp = nums[nums.length-1];
                    nums[nums.length-1] = nums[i-1];
                    nums[i-1] = temp;
                } else {
                    int temp = nums[target-1];
                    nums[target-1] = nums[i-1];
                    nums[i-1] = temp;
                }
                reverse(nums, i);
                break;
            }
        }
        if (i == 0) {
            reverse(nums, 0);
        }
    }
}