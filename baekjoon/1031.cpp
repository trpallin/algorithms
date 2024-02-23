#include <iostream>
#include <algorithm>
using namespace std;

bool compareDescA(pair<int, int> &a, pair<int, int> &b) {
    return a.first == b.first ? a.second < b.second : a.first > b.first;
}

bool compareDescB(pair<int, int> &a, pair<int, int> &b) {
    return a.first == b.first ? a.second > b.second : a.first > b.first;
}

bool checkMaxFlow() {
    
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int N, M;
    cin >> N >> M;
    pair<int, int> A[N], B[M];
    int sumA = 0, sumB = 0;
    int maxA = 0, maxB = 0;
    int posA = 0, posB = 0;
    short ans[N][M];

    for (int i = 0, a; i < N; i++) {
        cin >> a;
        A[i] = pair<int, int>(a, i);
        sumA += a;
        maxA = max(maxA, a);
        if (a > 0) posA++;
    }

    for (int i = 0, a; i < M; i++) {
        cin >> a;
        B[i] = pair<int, int>(a, i);
        sumB += a;
        maxB = max(maxB, a);
        if (a > 0) posB++;
    }

    if (sumA != sumB || maxA > posB || maxB > posA) {
        cout << -1;
    } else {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans[i][j] = 0;
            }
        }

        sort(A, A+N, compareDescA);
        sort(B, B+M, compareDescB);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < A[i].first; j++) {
                B[j].first--;
                ans[A[i].second][B[j].second]++;
            }

            sort(B, B+M, compareDescB);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cout << ans[i][j];
            }
            cout << "\n";
        }
    }

    return 0;
}