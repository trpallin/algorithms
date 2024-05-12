#include <iostream>
#include <algorithm>
using namespace std;

int rect[50][50];

int main() {
    int N, M;
    cin >> N >> M;
    string line;
    for (int i = 0; i < N; ++i) {
        cin >> line;
        for (int j = 0; j < M; ++j) {
            rect[i][j] = line[j];
        }
    }
    int maxLen = 1;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            for (int k = maxLen; k < min(N-i, M-j); ++k) {
                if (rect[i][j] == rect[i+k][j] && rect[i][j] == rect[i][j+k] && rect[i][j] == rect[i+k][j+k]) {
                    maxLen = k+1;
                }
            }
        }
    }
    cout << maxLen * maxLen;
    return 0;
}