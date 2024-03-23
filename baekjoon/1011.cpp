#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int T, x, y, halfDest;
    unsigned int current, recent;
    cin >> T;
    int *res = new int[T];
    int odd;
    for (int i = 0; i < T; i++) {
        cin >> x >> y;
        odd = (y - x) % 2 == 1;
        halfDest = odd ? (y - x) / 2 + 1 : (y - x) / 2;

        current = 0;
        recent = 0;

        while (current < halfDest) {
            current += ++recent;
        }
        
        if (recent > 2 * (current - halfDest) + odd) {
            res[i] = recent * 2;
        } else {
            res[i] = recent * 2 - 1;
        }
        
    }

    for (int i = 0; i < T; i++) {
        cout << res[i] << "\n";
    }

    return 0;
}