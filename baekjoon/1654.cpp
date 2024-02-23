#include <vector>
#include <iostream>
using namespace std;

int main() {
    int k, n;
    int i;
    cin >> k >> n;

    int *list = new int[k];
    int max = 0;

    for (i = 0; i < k; i++) {
        cin >> list[i];
        if (list[i] > max) max = list[i];
    }

    int validAns = 1;
    int tempAns = validAns;
    int div;
    int gap = max;

    while (gap > 0) {
        div = 0;

        for (i = 0; i < k; i++) {
            div += list[i] / tempAns;
            if (div >= n) {
                validAns = tempAns;
                gap = gap / 2 + 1;
                tempAns += gap;
                break;
            }
        }

        if (i == k) {
            gap = (tempAns - validAns) / 2;
            tempAns -= gap;
        }
    }

    cout << validAns << endl;

    return 0;
}