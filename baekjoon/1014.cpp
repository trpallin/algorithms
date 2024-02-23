#include <iostream>
#include <algorithm>
using namespace std;

inline bool check_empty(char row[], int k) {
    return row[k] == 'x' || row[k] == '.';
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int C, M, N;
    cin >> C;

    int ans[C];
    int i, j, k;
    int count;
    char seat;

    for (i = 0; i < C; i++) {
        cin >> M >> N;
        count = 0;
        char row[N], prev_row[N];
        
        for (k = 0; k < N; k++) {
            prev_row[k] = 'x';
        }

        for (j = 0; j < M; j++) {
            for (k = 0; k < N; k++) {
                cin >> row[k];
            }

            for (k = 0; k < N; k++) {
                if (row[k] == '.') {
                    if (k == 0) {
                        if (check_empty(row, k+1) && check_empty(prev_row, k+1)) {
                            row[k] = 'o';
                            count++;
                        }
                    } else if (k == N-1) {
                        if (check_empty(row, k-1) && check_empty(prev_row, k-1)) {
                            row[k] = 'o';
                            count++;
                        }
                    } else if (check_empty(row, k-1) && check_empty(row, k+1) && check_empty(prev_row, k-1) && check_empty(prev_row, k+1)) {
                        row[k] = 'o';
                        count++;
                    }
                }
            }

            copy(row, row + N, prev_row);
        }

        ans[i] = count;
    }

    for (i = 0; i < C; i++) {
        cout << ans[i] << "\n";
    }

    return 0;
}