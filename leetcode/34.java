class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid-1] < target)) {
                res[0] = mid;
                break;
            }
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (res[0] == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        left = res[0];
        right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid+1] > target)) {
                res[1] = mid;
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}