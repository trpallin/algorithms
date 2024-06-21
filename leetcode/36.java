class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] test = new boolean[9];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char cell = board[i][j];
                if (cell != '.') {
                    if (test[Character.getNumericValue(cell)-1]) {
                        return false;
                    } else {
                        test[Character.getNumericValue(cell)-1] = true;
                    }
                }
            }
            for (int j = 0; j < 9; ++j) {
                test[j] = false;
            }
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char cell = board[j][i];
                if (cell != '.') {
                    if (test[Character.getNumericValue(cell)-1]) {
                        return false;
                    } else {
                        test[Character.getNumericValue(cell)-1] = true;
                    }
                }
            }
            for (int j = 0; j < 9; ++j) {
                test[j] = false;
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    for (int l = 0; l < 3; ++l) {
                        char cell = board[3*i + k][3*j + l];
                        if (cell != '.') {
                            if (test[Character.getNumericValue(cell)-1]) {
                                return false;
                            } else {
                                test[Character.getNumericValue(cell)-1] = true;
                            }
                        }
                    }
                }
                for (int k = 0; k < 9; ++k) {
                    test[k] = false;
                }
            }
        }

        return true;
    }
}