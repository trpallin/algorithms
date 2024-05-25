class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<pair<int, int>> vecWithIdx;
        for (int i = 0; i != nums.size(); i++) {
            vecWithIdx.push_back(pair<int, int> (nums[i], i));
        }
        sort(vecWithIdx.begin(), vecWithIdx.end());
        int start = 0;
        int end = nums.size()-1;

        while (start < end) {
            int sum = vecWithIdx[start].first + vecWithIdx[end].first;
            if (sum == target) {
                return vector<int> {vecWithIdx[start].second, vecWithIdx[end].second};
            }
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return vector<int> {0, 0}; // cannot be reached
    }
};