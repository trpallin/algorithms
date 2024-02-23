#include <vector>
#include <iostream>
using namespace std;

#define INF 100000

/**
 * A bad solution. There is much more simple and saving-memory way.
 */

int main() {
    int n, k;
    int ans;

    cin >> n >> k;

    if (n >= k) {
        ans = n - k;
    } else {
        int *arr = new int[k+3];
        for (int i = 0; i < k+3; i++) {
            arr[i] = INF;
        }

        for (int i = 0; i <= n; i++) {
            arr[i] = n - i;
        }

        for (int i = 0; i < k; i++) {
            if (2*i < k+2) {
                if (arr[i+1] > arr[i] + 1) {
                    arr[i+1] = arr[i] + 1;
                }
                if (arr[2*i] > arr[i] + 1) {
                    int count = arr[i] + 1;
                    arr[2*i] = count;

                    int temp = 2*i - 1;
                    
                    while (arr[temp] == INF) {
                        arr[temp--] = ++count;
                    }
                }
            } else {
                if (arr[i+1] > arr[i] + 1) {
                    arr[i+1] = arr[i] + 1;
                }
            }
            
        }

        ans = arr[k];
    }

    cout << ans << '\n';
    return 0;
}