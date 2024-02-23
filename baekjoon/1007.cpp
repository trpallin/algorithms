#include <iostream>
#include <algorithm>
#include <math.h>
using namespace std;

pair<int, int> calc(pair<int, int> *p, pair<int, int> *end, int n, pair<int, int> sum) {
    if (n == 0 || distance(p, end) == n) {
        int leftSumX = 0;
        int leftSumY = 0;

        for (auto iter = p; iter != end; iter++) {
            leftSumX += iter->first;
            leftSumY += iter->second;
        }

        if (n == 0)
            return pair<int, int>(sum.first + leftSumX, sum.second + leftSumY);
        else
            return pair<int, int>(sum.first - leftSumX, sum.second - leftSumY);
    } else {
        pair<int, int> a, b;
        pair<int, int> cur = *p;
        a = calc(p+1, end, n, pair<int, int>(sum.first + cur.first, sum.second + cur.second));
        b = calc(p+1, end, n-1, pair<int, int>(sum.first - cur.first, sum.second - cur.second));

        if (pow(a.first, 2) + pow(a.second, 2) < pow(b.first, 2) + pow(b.second, 2))
            return a;
        else
            return b;
    }
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int T, N;
    cin >> T;
    double ans[T];
    pair<int, int> min;

    for (int i = 0; i < T; i++) {
        cin >> N;
        pair<int, int> p[N];
        int x, y;

        for (int j = 0; j < N; j++) {
            cin >> x >> y;
            p[j] = pair<int, int>(x, y);
        }

        min = calc(p, p+N, N/2, pair<int, int>(0, 0));

        ans[i] = sqrt(pow((double)min.first, 2) + pow((double)min.second, 2));
    }

    cout.precision(13);

    for (int i = 0; i < T; i++) {
        cout << ans[i] << "\n";
    }
    return 0;
}