#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int N, L;
    cin >> N >> L;
    int sum = 0;
    for (int i = 0; i < L; i++) {
        sum += i;
    }

    while (sum <= N && L <= 100) {
        if ((N - sum) % L == 0) {
            int offset = (N - sum) / L;
            for (int i = 0; i < L; i++) {
                cout << offset + i << " ";
            }
            return 0;
        }
        sum += L++;
    }
    cout << -1;
    
    return 0;
}