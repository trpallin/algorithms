class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int minGap = 100000;
        int res;
        for (int i = 0; i < nums.size(); ++i) {
            int t = nums[i] - target;
            int left = i+1;
            int right = nums.size() - 1;
            
            while (left < right) {
                int gap = abs(nums[left] + nums[right] + t);
                if (gap < minGap) {
                    minGap = gap;
                    res = nums[i] + nums[left] + nums[right];
                }
                if (left + 1 < nums.size() && nums[left] + nums[right] + t < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
};