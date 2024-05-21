#include <iostream>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        int maxHalfLen = 0;
        int maxIdx = 0;
        bool odd = true;
        string s_rev(s.rbegin(), s.rend());
        for (int i = 0; i < s.length(); ++i) {
            int halfLen = 1;
            while (i-halfLen >= 0 && i+halfLen < s.length() && s[i-halfLen] == s[i+halfLen]) {
                halfLen++;
            }
            halfLen--;
            if (halfLen > maxHalfLen) {
                maxHalfLen = halfLen;
                maxIdx = i;
                odd = true;
            }
        }

        for (int i = 0; i < s.length()-1; ++i) {
            int halfLen = 1;
            while (i+1-halfLen >= 0 && i+halfLen < s.length() && s[i+1-halfLen] == s[i+halfLen]) {
                halfLen++;
            }
            halfLen--;
            if (halfLen > maxHalfLen) {
                maxHalfLen = halfLen;
                maxIdx = i;
                odd = false;
            }
        }

        return odd ? s.substr(maxIdx - maxHalfLen, 2*maxHalfLen + 1) : s.substr(maxIdx + 1 - maxHalfLen, 2*maxHalfLen);
    }
};

int main() {
    Solution sol;
    cout << sol.longestPalindrome("abcbabc") << "\n";
    return 0;
}