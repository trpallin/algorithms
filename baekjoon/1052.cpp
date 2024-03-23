#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int N, K;
    cin >> N >> K;
    int *left = new int[24];
    for (int i = 0; i < 24; i++) {
        left[i] = 0;
    }
    int idx = 0;
    int leftSum = 0;
    while (N > 0) {
        left[idx++] = N % 2;
        leftSum += N % 2;
        N /= 2;
    }
    
    if (leftSum <= K) {
        cout << 0;
    } else {
        int needToRemove = leftSum - K;
        int bought = 0;
        int minVolume = 0;
        while (left[minVolume] == 0) minVolume++;
        left[minVolume] = 0;

        for (int i = minVolume; i < 24 && needToRemove > 0; i++) {
            if (left[i]) needToRemove--;
            else bought += 1 << i;
        }
        cout << bought;
    }

    return 0;
}