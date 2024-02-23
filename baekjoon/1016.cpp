#include <iostream>
#include <math.h>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    uint64_t min, max;
    cin >> min >> max;
    
    bool isNN[max-min+1];
    for (uint64_t i = 0; i < max-min+1; i++)
        isNN[i] = true;

    uint64_t iter = sqrt(min);
    uint64_t limit = sqrt(max) + 1;

    iter = iter*iter < min ? iter+1 : iter;

    uint64_t sq;
    uint64_t n;

    for (uint64_t i = 2; i < limit; i++) {
        sq = i*i;
        n = min % sq ? min / sq + 1 : min / sq;

        for (; sq*n <= max; n++) {
            isNN[sq*n - min] = false;
        }
    }

    int count = 0;

    for (uint64_t i = 0; i < max-min+1; i++) {
        if (isNN[i]) count++;
    }

    cout << count;

    return 0;
}