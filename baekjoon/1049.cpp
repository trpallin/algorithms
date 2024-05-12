#include <iostream>
#include <algorithm>
using namespace std;

#define MAX_PRICE 1000

int main() {
    int N, M;
    cin >> N >> M;
    int priceForSix, priceForOne;
    int minPriceForSix = MAX_PRICE, minPriceForOne = MAX_PRICE;

    for (int i = 0; i < M; ++i) {
        cin >> priceForSix >> priceForOne;
        minPriceForSix = min(minPriceForSix, priceForSix);
        minPriceForOne = min(minPriceForOne, priceForOne);
    }

    if (minPriceForSix > 6 * minPriceForOne) {
        cout << minPriceForOne * N;
    } else {
        int leftCharge = (N % 6) * minPriceForOne;
        leftCharge = min(leftCharge, minPriceForSix);
        cout << (N / 6) * minPriceForSix + leftCharge;
    }

    return 0;
}