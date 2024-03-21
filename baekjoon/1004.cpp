#include <iostream>
#include <cmath>
using namespace std;

inline int dist_sq(int x1, int y1, int x2, int y2) {
    return pow(x1 - x2, 2) + pow(y1 - y2, 2);
}

int main() {
    int T, n;
    int x1, y1, x2, y2;
    int count;
    int cx, cy, cr;

    cin >> T;

    int *ans = new int[T];

    for (int i = 0; i < T; i++) {
        cin >> x1 >> y1 >> x2 >> y2;
        cin >> n;
        count = 0;

        while (n--) {
            cin >> cx >> cy >> cr;

            if ((dist_sq(x1, y1, cx, cy) < pow(cr, 2) && dist_sq(x2, y2, cx, cy) > pow(cr, 2)) ||
            (dist_sq(x1, y1, cx, cy) > pow(cr, 2) && dist_sq(x2, y2, cx, cy) < pow(cr, 2))) {
                count++;
            }

        }
        ans[i] = count;
    }

    for (int i = 0; i < T; i++) {
        cout << ans[i] << "\n";
    }

    delete[] ans;

    return 0;
}