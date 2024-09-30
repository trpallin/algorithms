class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE - 1;
        int secondMin = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= min) {
                min = n;
            } else if (n <= secondMin) {
                secondMin = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
