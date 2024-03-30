#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int T;
    string *res;
    string line;
    cin >> T;
    res = new string[T];

    for (int i = 0; i < T; i++) {
        cin >> line;
        int idx = 0;
        bool yes = false;

        while (idx < line.length()) {
            if (line.substr(idx, 3) == "100") {
                idx += 3;
                while (idx < line.length() && line.substr(idx, 1) == "0") idx++;
                if (idx < line.length() && line.substr(idx, 1) == "1") {
                    idx++;
                    yes = true;
                    while (idx < line.length() && line.substr(idx, 1) == "1" && line.substr(idx, 3) != "100") {
                        idx++;
                    }
                } else {
                    yes = false;
                    break;
                }
            } else if (line.substr(idx, 2) == "01") {
                idx += 2;
                yes = true;
            } else {
                yes = false;
                break;
            }
        }
        res[i] = yes ? "YES" : "NO";
    }

    for (int i = 0; i < T; i++) {
        cout << res[i] << "\n";
    }

    return 0;
}