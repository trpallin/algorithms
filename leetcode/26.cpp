class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int uniqueNum = 1;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] != nums[uniqueNum - 1]) {
                nums[uniqueNum++] = nums[i];
            }
        }
        return uniqueNum;
    }
};