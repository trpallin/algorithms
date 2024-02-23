#include <iostream>
#include <math.h>
using namespace std;

int getPeriod(int n) {
    switch (n) {
        case 0:
        case 1:
        case 5:
        case 6:
            return 1;
        case 4:
        case 9:
            return 2;
        case 2:
        case 3:
        case 7:
        case 8:
            return 4;
        default:
            return 1;
    }
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

    int T, a, b;
    cin >> T;
    int ans[T];
    int p;
    int k;

    for (int i = 0; i < T; i++) {
        cin >> a >> b;
        p = getPeriod(a%10);
        k = b % p == 0 ? p : b % p;
        ans[i] = p == 1 ? a % 10 : (int)pow(a%10, k) % 10;
        if (ans[i] == 0) ans[i] = 10;
    }
    
    for (int i = 0; i < T; i++) {
        cout << ans[i] << "\n";
    }

    return 0;
}