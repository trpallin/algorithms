class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (x == 1.0) {
            return 1.0;
        }
        if (x == -1.0) {
            return (n & 1) == 0 ? 1 : -1;
        }
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                x *= x;
            } else {
                n = -n;
            }
        }
        double ans = 1.0;
        double currentProduct = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= currentProduct;
            }
            currentProduct *= currentProduct;
            n >>= 1;
        }
        return ans;
    }
}