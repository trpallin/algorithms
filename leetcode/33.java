class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == nums.length - 1) {
                break;
            } else if (nums[mid] > nums[mid+1]) {
                break;
            } else if (nums[mid] >= nums[left]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        if (target >= nums[0]) {
            left = 0;
            right = mid;
        } else {
            left = mid+1;
            right = nums.length - 1;
        }

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}