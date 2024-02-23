#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int N;
    cin >> N;
    int64_t h[N];

    for (int i = 0; i < N; i++) {
        cin >> h[i];
    }

    int max_num = 0;
    int bd_num;
    int64_t incl_numer, incl_denom;

    for (int i = 0; i < N; i++) {
        bd_num = 0;
        incl_numer = -1000000000; incl_denom = 1;

        for (int j = i-1; j >= 0; j--) {
            if ((h[j]-h[i])*incl_denom > incl_numer*(i-j)) {
                incl_numer = h[j] - h[i];
                incl_denom = i - j;
                bd_num++;
            }
        }

        incl_numer = -1000000000; incl_denom = 1;

        for (int j = i+1; j < N; j++) {
            if ((h[j]-h[i])*incl_denom > incl_numer*(j-i)) {
                incl_numer = h[j] - h[i];
                incl_denom = j - i;
                bd_num++;
            }
        }

        max_num = max(bd_num, max_num);
    }

    cout << max_num << "\n";

    return 0;
}