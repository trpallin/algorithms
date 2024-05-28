class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits == "") {
            return vector<string> ();
        }
        vector<string> ans {""};
        
        for (int i = 0; i < digits.length(); i++) {
            string options;

            switch (digits[i]) {
                case '2':
                    options = "abc";
                    break;
                case '3':
                    options = "def";
                    break;
                case '4':
                    options = "ghi";
                    break;
                case '5':
                    options = "jkl";
                    break;
                case '6':
                    options = "mno";
                    break;
                case '7':
                    options = "pqrs";
                    break;
                case '8':
                    options = "tuv";
                    break;
                case '9':
                    options = "wxyz";
                    break;
                default:
                    break;
            }
            
            int oldSize = ans.size();

            for (int j = 0; j < oldSize; ++j) {
                for (int k = 0; k < options.length(); ++k) {
                    ans.push_back(ans[j] + options[k]);
                }
            }

            ans.erase(ans.begin(), ans.begin() + oldSize);
        }

        return ans;
    }
};