#include <iostream>
#include <algorithm>
using namespace std;

#define INPUT_LIMIT 1001

int main() {
    int A;
    int x;
    int max_input = 0;
    cin >> A;

    int arr[A];
    int arr2[INPUT_LIMIT];
    int result[A];

    for (int i = 0; i < INPUT_LIMIT; i++) {
        arr2[i] = 0;
    }

    for (int i = 0; i < A; i++) {
        cin >> x;
        max_input = max(max_input, x);
        arr[i] = x;
        arr2[x]++;
    }

    int val = 0;

    for (int i = 0; i < max_input+1; i++) {
        arr2[i] += val;
        val = arr2[i];
    }

    for (int i = 0; i < A; i++) {
        result[i] = arr2[arr[i]-1]++;
    }

    for (int i = 0; i < A; i++) {
        cout << result[i] << " ";
    }

    cout << "\n";

    return 0;
}