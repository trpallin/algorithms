class Solution {
    List<String> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();

    private boolean valid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        return Integer.parseInt(s) <= 255;
    }

    private void solve(String s, int n) {
        if (n == s.length() && list.size() == 4) {
            ans.add(String.join(".", list));
            return;
        }
        if (n == s.length() || list.size() == 4) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (n + i > s.length())
                return;
            String num = s.substring(n, n + i);
            if (valid(num)) {
                list.add(num);
                solve(s, n + i);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12)
            return ans;
        solve(s, 0);
        return ans;
    }
}