class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                countStack.push(count);
                sbStack.push(sb);
                count = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                int repeats = countStack.pop();
                StringBuilder repeatSb = sb;
                sb = sbStack.pop();
                while (repeats-- > 0) {
                    sb.append(repeatSb);
                }
            } else if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}