class Solution {
    private static int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    boolean[] availableNumbers;
    int size;

    private int getNthLeastAvailableNumber(int n) {
        int count = 1;
        for (int i = 0; i < size; i++) {
            if (!availableNumbers[i] && (count++ == n)) {
                availableNumbers[i] = true;
                return i + 1;
            }
        }
        return -1;
    }

    public String getPermutation(int n, int k) {
        String res = "";
        availableNumbers = new boolean[n];
        size = n;

        k--;
        for (int i = n; i > 0; i--) {
            int t = k / factorial[i - 1];
            k %= factorial[i - 1];
            int num = getNthLeastAvailableNumber(t + 1);
            res += num;
        }

        return res;
    }
}