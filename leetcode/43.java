class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length();
        int n = num2.length();
        int[] sums = new int[m + n];

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = sums[i + j + 1] + mul;
                sums[i + j + 1] = sum % 10;
                sums[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : sums) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        
        return sb.toString();
    }
}