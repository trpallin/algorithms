class Solution {
public:
    int myAtoi(string s) {
        size_t first = s.find_first_not_of(' ');
        if (first == string::npos) {
            return 0;
        }
        s = s.substr(first);
        bool positive = true;
        if (s[0] == '-') {
            positive = false;
            s = s.substr(1);
        } else if (s[0] == '+') {
            s = s.substr(1);
        }
        int endIdx = s.length();
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] < '0' || s[i] > '9') {
                endIdx = i;
                break;
            }
        }
        if (endIdx == 0) return 0;
        if (endIdx != s.length())
            s = s.substr(0, endIdx);
        first = s.find_first_not_of('0');
        if (first == string::npos) {
            return 0;
        }
        s = s.substr(first);
        if (s.length() > 10) {
            return positive ? 2147483647 : -2147483648;
        }
        long long n = positive ? stoll(s) : stoll("-" + s);
        if (n > 2147483647) {
            return 2147483647;
        } else if (n < -2147483648) {
            return -2147483648;
        } else {
            return n;
        }
    }
};