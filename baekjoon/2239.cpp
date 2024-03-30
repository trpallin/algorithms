#include <iostream>
using namespace std;

string getCandidates(string *lines, int row, int col) {
    string candidates = "111111111";
    for (int i = 0; i < 9; i++) {
        if (lines[row][i] != '0') {
            candidates[lines[row][i] - 49] = '0';
        }
        if (lines[i][col] != '0') {
            candidates[lines[i][col] - 49] = '0';
        }
    }
    int b_row = int(row / 3) * 3, b_col = int(col / 3) * 3;

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (lines[b_row + i][b_col + j] != '0') {
                candidates[lines[b_row + i][b_col + j] - 49] = '0';
            }
        }
    }

    return candidates;
}

bool solve(string *lines, int row, int col) {
    if (row >= 9) return true;
    if (lines[row][col] == '0') {
        string candidates = getCandidates(lines, row, col);
        for (int i = 0; i < 9; i++) {
            if (candidates[i] == '1') {
                lines[row][col] = 49 + i;
                if (solve(lines, row, col)) return true;
                lines[row][col] = '0';
            }
        }
        return false;
    } else {
        if (col < 8) return solve(lines, row, col + 1);
        else {
            return solve(lines, row + 1, 0);
        }
    }
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    string lines[9];
    for (int i = 0; i < 9; i++) {
        cin >> lines[i];
    }

    solve(lines, 0, 0);

    for (int i = 0; i < 9; i++) {
        cout << lines[i] << "\n";
    }

    return 0;
}