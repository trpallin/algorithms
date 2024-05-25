class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        char c, top;
        for (int i = 0; i < s.length(); ++i) {
            c = s[i];
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.empty()) return false;
                top = st.top();
                if (c == ')') {
                    if (top == '(') {
                        st.pop();
                    } else return false;
                } else if (c == '}') {
                    if (top == '{') {
                        st.pop();
                    } else return false;
                } else { // c == ']'
                    if (top == '[') {
                        st.pop();
                    } else return false;
                }
            }
        }
        return st.empty();
    }
};