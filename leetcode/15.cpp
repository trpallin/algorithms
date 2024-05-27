class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.size() - 1;

            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.push_back(vector<int> {nums[i], nums[left], nums[right]});
                    while (left+1 < nums.size() && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (right-1 >= 0 && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
};