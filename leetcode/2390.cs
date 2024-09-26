public class Solution {
    public string RemoveStars(string s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.Length; i++) {
            if (s[i] == '*') {
                if (sb.Length > 0)
                    sb.Length--;
            } else {
                sb.Append(s[i]);
            }
        }
        return sb.ToString();
    }
}