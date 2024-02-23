#include <iostream>
#include <algorithm>
using namespace std;

void apply_score(char **seat, int **score, const int M, const int N) {
    int sum;
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            if (seat[i][j] == '.') {
                sum = 1;

                if (i-1 >= 0 && j-1 >= 0) {
                    if (seat[i-1][j-1] == 'x') sum++;
                } else sum++;

                if (i-1 >= 0 && j+1 < N) {
                    if (seat[i-1][j+1] == 'x') sum++;
                } else sum++;

                if (i+1 < M && j-1 >= 0) {
                    if (seat[i+1][j-1] == 'x') sum++;
                } else sum++;

                if (i+1 < M && j+1 < N) {
                    if (seat[i+1][j+1] == 'x') sum++;
                } else sum++;

                if (j-1 >= 0) {
                    if (seat[i][j-1] == 'x') sum++;
                } else sum++;

                if (j+1 < N) {
                    if (seat[i][j+1] == 'x') sum++;
                } else sum++;

                score[i][j] = sum;
            } else {
                score[i][j] = 0;
            }   
        }
    }
}

void update_to_x(char **seat, int **score, int r, int c, const int M, const int N) {
    seat[r][c] = 'x';

    if (r-1 >= 0 && c-1 >= 0) {
        seat[r-1][c-1] = 'x';
    }
    if (c-1 >= 0) {
        seat[r][c-1] = 'x';
    }
    if (r+1 < M && c-1 >= 0) {
        seat[r+1][c-1] = 'x';
    }
    if (r-1 >= 0 && c+1 < N) {
        seat[r-1][c+1] = 'x';
    }
    if (c+1 < N) {
        seat[r][c+1] = 'x';
    }
    if (r+1 < M && c+1 < N) {
        seat[r+1][c+1] = 'x';
    }

    apply_score(seat, score, M, N);
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int C, M, N;
    cin >> C;

    int ans[C];
    int i, j, k, l;
    int count;

    for (i = 0; i < C; i++) {
        cin >> M >> N;
        char **seat = new char*[M];
        int **score = new int*[M];
        count = 0;

        for (j = 0; j < M; j++) {
            seat[j] = new char[N];
            score[j] = new int[N];
        }
        
        for (j = 0; j < M; j++) {
            for (k = 0; k < N; k++) {
                cin >> seat[j][k];
            }
        }

        apply_score(seat, score, M, N);

        int max_val;
        int max_row, max_col;
        
        while (true) {
            max_val = 0;

            for (j = 0; j < M; j++) {
                for (k = 0; k < N; k++) {
                    if (score[j][k] > max_val) {
                        max_row = j;
                        max_col = k;
                        max_val = score[j][k];
                    }
                }
            }

            if (max_val > 0) {
                count++;
                cout << "[UPDATE] " << max_row << ", " << max_col << "\n";
                
                update_to_x(seat, score, max_row, max_col, M, N);
                for (j = 0; j < M; j++) {
                    for (k = 0; k < N; k++) {
                        cout << score[j][k] << " ";
                    }
                    cout << "\n";
                }
            } else {
                break;
            }
        }
        
        ans[i] = count;

        for (j = 0; j < M; j++) {
            delete[] seat[j];
            delete[] score[j];
        }

        delete[] seat;
        delete[] score;
    }

    for (i = 0; i < C; i++) {
        cout << ans[i] << "\n";
    }

    return 0;
}