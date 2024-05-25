class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ans = "";
        char common;
        for (int i = 0; i < 200; ++i) {
            for (int j = 0; j < strs.size(); ++j) {
                if (i >= strs[j].length()) {
                    return ans;
                }
                if (j == 0) common = strs[j][i];
                else if (strs[j][i] != common) {
                    return ans;
                }
                if (j == strs.size() - 1) {
                    ans += common;
                }
            }
        }
        return ans;
    }
};