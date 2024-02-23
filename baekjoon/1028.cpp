#include <iostream>
#include <algorithm>
using namespace std;

int R, C;

bool hasDiaWithSize(bool *diaMine, int cr, int cc, int n) {
    if (n == 1) return diaMine[cr*C + cc];
    int r, c;
    int i;
    r = cr - n + 1;
    c = cc;
    for (i = 0; i < n-1; ++i) {
        if (!diaMine[r*C + c]) return false;
        ++r;
        ++c;
    }
    for (i = 0; i < n-1; ++i) {
        if (!diaMine[r*C + c]) return false;
        ++r;
        --c;
    }
    for (i = 0; i < n-1; ++i) {
        if (!diaMine[r*C + c]) return false;
        --r;
        --c;
    }
    for (i = 0; i < n-1; ++i) {
        if (!diaMine[r*C + c]) return false;
        --r;
        ++c;
    }
    return true;
}

int calcDiaLimit(int R, int C) {
    return (min(R, C) + 1) / 2;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int i, j;
    int ans = 0;
    cin >> R >> C;
    bool *diaMine = new bool[R*C];
    int limit = calcDiaLimit(R, C);
    int curr = limit;
    bool found = false;
    string row;

    for (i = 0; i < R; ++i) {
        cin >> row;
        for (j = 0; j < C; ++j) {
            diaMine[C*i + j] = row[j] == '1' ? true : false;
        }
    }

    while (curr > 0) {
        for (i = curr-1; i < R-curr+1; ++i) {
            for (j = curr-1; j < C-curr+1; ++j) {
                if (hasDiaWithSize(diaMine, i, j, curr)) {
                    found = true;
                    ans = curr;
                    break;
                };
            }
            if (found) break;
        }
        if (found) break;
        --curr;
    }

    cout << ans << "\n";
    delete[] diaMine;

    return 0;
}