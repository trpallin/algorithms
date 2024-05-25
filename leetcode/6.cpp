class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        string res = "";
        int period = 2*numRows - 2;
        for (int i = 0; i < numRows; ++i) {
            int idx = i;
            if (i == 0 || i == numRows - 1) {
                while (idx < s.length()) {
                    res += s[idx];
                    idx += period;
                }
            } else {
                while (idx < s.length()) {
                    res += s[idx];
                    int gap = numRows - i - 1;
                    if (idx+2*gap < s.length()) {
                        res += s[idx+2*gap];
                    }
                    idx += period;
                }
            }
        }
        return res;
    }
};