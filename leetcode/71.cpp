class Solution {
public:
    string simplifyPath(string path) {
        deque<string> paths;
        string curr = "";

        for (int i = 0; i < path.length(); i++) {
            if (path[i] == '/') {
                if (curr == "..") {
                    if (!paths.empty()) {
                        paths.pop_back();
                    }
                } else if (curr != "." && curr != "") {
                    paths.push_back(curr);
                }
                curr = "";
            } else {
                curr += path[i];
            }
        }

        if (curr == "..") {
            if (!paths.empty()) {
                paths.pop_back();
            }
        } else if (curr != "." && curr != "") {
            paths.push_back(curr);
        }

        string ans = "";
        while (!paths.empty()) {
            ans += ('/' + paths.front());
            paths.pop_front();
        }

        return ans == "" ? "/" : ans;
    }
};