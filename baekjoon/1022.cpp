#include <iostream>
#include <algorithm>
using namespace std;

int getNum(int r, int c) {
    if (abs(r) >= abs(c)) {
        if (r >= 0) return 4*r*r + 3*r + 1 + c;
        else return 4*r*r + r + 1 - c;
    } else {
        if (c >= 0) return 4*c*c - 3*c + 1 - r;
        else return 4*c*c - c + 1 + r;
    }
}

int getLen(int m) {
    int l = 0;

    while (m > 0) {
        l++;
        m /= 10;
    }

    return l;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int r1, c1, r2, c2;
    cin >> r1 >> c1 >> r2 >> c2;
    // int startNum;
    int res[r2-r1+1][c2-c1+1];
    // int idX = 0, idY = 0;
    int maxVal = 0;

    for (int i = 0; i <= r2-r1; i++) {
        for (int j = 0; j <= c2-c1; j++) {
            res[i][j] = getNum(r1+i, c1+j);
            maxVal = max(maxVal, res[i][j]);
        }
    }

    int maxLen = getLen(maxVal);
    int spaceLen;

    for (int i = 0; i <= r2-r1; i++) {
        for (int j = 0; j <= c2-c1; j++) {
            spaceLen = maxLen - getLen(res[i][j]);
            for (int k = 0; k < spaceLen; k++) {
                cout << " ";
            }
            cout << res[i][j];
            
            if (j < c2-c1) cout << " ";
        }
        cout << "\n";
    }
    
    return 0;
}