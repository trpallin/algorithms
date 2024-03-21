#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int n;
    int x1, y1, r1, x2, y2, r2;
    int sqr_dist;
    cin >> n;
    int *result = new int[n];

    for (int i = 0; i < n; i++) {
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
        sqr_dist = pow(x1 - x2, 2) + pow(y1 - y2, 2);

        if (pow(r1, 2) > sqr_dist || pow(r2, 2) > sqr_dist) {
            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) result[i] = -1;
                else result[i] = 0;
            } else {
                if (pow(r1 - r2, 2) > sqr_dist) result[i] = 0;
                else if(pow(r1 - r2, 2) == sqr_dist) result[i] = 1;
                else result[i] = 2;
            }
        } else {
            if (pow(r1 + r2, 2) < sqr_dist) result[i] = 0;
            else if (pow(r1 + r2, 2)  == sqr_dist) result[i] = 1;
            else result[i] = 2;
        }
    }

    for (int i = 0; i < n; i++) {
        cout << result[i] << "\n";
    }

    delete[] result;

    return 0;
}