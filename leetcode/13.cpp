class Solution {
public:
    int romanToInt(string s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i + 1 < s.length()) {
                if ((s[i+1] == 'V' || s[i+1] == 'X') && s[i] == 'I') {
                    ans -= 1;
                    i++;
                } else if ((s[i+1] == 'L' || s[i+1] == 'C') && s[i] == 'X') {
                    ans -= 10;
                    i++;
                } else if ((s[i+1] == 'D' || s[i+1] == 'M') && s[i] == 'C') {
                    ans -= 100;
                    i++;
                }
            }
            switch (s[i]) {
                case 'I':
                    ans += 1;
                    break;
                case 'V':
                    ans += 5;
                    break;
                case 'X':
                    ans += 10;
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'C':
                    ans += 100;
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'M':
                    ans += 1000;
                    break;
            }
        }
        return ans;
    }
};