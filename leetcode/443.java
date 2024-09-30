class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;
        int i = 0;

        while (i < n) {
            char ch = chars[i];
            int len = 1;
            while (i + len < n && chars[i + len] == ch) {
                len++;
            }
            chars[idx++] = ch;
            if (len > 1) {
                for (char c : Integer.toString(len).toCharArray()) {
                    chars[idx++] = c;
                }
            }
            i += len;
        }

        return idx;
    }
}