#include <iostream>
#include <math.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int N, r, c;
    cin >> N >> r >> c;
    int res = 0;
    N = pow(2, N);

    while (N > 1) {
        if (r < N / 2 && c < N / 2) {
            // do nothing
        } else if (r < N / 2 && c >= N / 2) {
            res += (N / 2) * (N / 2);
            c -= N / 2;
        } else if (r >= N / 2 && c < N / 2) {
            res += (N / 2) * (N / 2) * 2;
            r -= N / 2;
        } else {
            res += (N / 2) * (N / 2) * 3;
            r -= N / 2;
            c -= N / 2;
        }
        N /= 2;
    }

    cout << res;

    return 0;
}