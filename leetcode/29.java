class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean neg = (dividend < 0) ^ (divisor < 0);

        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);

        int res = 0;

        while (dividendAbs >= divisorAbs) {
            long tempDivisor = divisorAbs, tempQuotient = 1;
            while (dividendAbs >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                tempQuotient <<= 1;
            }
            dividendAbs -= tempDivisor;
            res += tempQuotient;
        }

        return neg ? -res : res;
    }
}