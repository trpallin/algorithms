#include <algorithm>
#include <string>
#include <iostream>
using namespace std;

class Solution {
public:
    int reverse(int x) {
        if (x < 1000000000 && x > -1000000000) {
            string s = x >= 0 ? to_string(x) : to_string(x * (-1));
            std::reverse(s.begin(), s.end());
            return x >= 0 ? stoi(s) : stoi("-" + s);
        }

        string s = x >= 0 ? to_string(x) : to_string(x).substr(1);
        std::reverse(s.begin(), s.end());

        if (x >= 0) {
            if (s > "2147483647") return 0;
            return stoi(s);
        } else {
            if (s > "2147483648") return 0;
            return stoi("-" + s);
        }
    }
};

int main() {
    Solution sol;
    cout << sol.reverse(2147483647) << "\n";
    return 0;
}