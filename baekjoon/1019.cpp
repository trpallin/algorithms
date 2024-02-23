#include <iostream>
#include <string>
#include <math.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int N;
    cin >> N;
    string str = to_string(N);
    int64_t ans[10];
    for (int i = 0; i < 10; ++i) {
        ans[i] = 0;
    }

    int len = str.length();
    int temp;
    string tempStr, tempStr2;
    cout.precision(10);
    for (int i = 0; i < 10; ++i) {
        if (i == 0) {
            for (int j = 1; j < len; ++j) {
                int idx = str[j] - '0';
                if (idx > i) {
                    tempStr = str;
                    tempStr2 = tempStr.substr(0, j);
                    ans[i] += ((stoi(tempStr2)+1) * pow(10, len-j-1) - pow(10, len-j-1));
                } else if (idx == i) {
                    tempStr = str;
                    tempStr.erase(j, 1);
                    temp = stoi(tempStr);
                    ans[i] += (temp+1-pow(10, len-j-1));
                }
            }
        } else {
            for (int j = 0; j < len; ++j) {
                int idx = str[j] - '0';
                if (idx > i) {
                    tempStr = str;
                    if (j == 0) {
                        ans[i] += (pow(10, len-j-1));
                    } else {
                        tempStr2 = tempStr.substr(0, j);
                        ans[i] += ((stoi(tempStr2)+1) * pow(10, len-j-1));
                    }                    
                } else if (idx < i) {
                    tempStr = str;
                    if (j > 0) {
                        tempStr2 = tempStr.substr(0, j);
                        ans[i] += ((stoi(tempStr2)) * pow(10, len-j-1));
                    }
                } else {
                    tempStr = str;
                    if (len > 1) {
                        tempStr.erase(j, 1);
                        temp = stoi(tempStr);
                        ans[i] += (temp+1);
                    } else {
                        ans[i]++;
                    }
                }
            }
        }        
    }

    for (int i = 0; i < 9; ++i) {
        cout << ans[i] << " ";
    }
    cout << ans[9] << "\n";
    return 0;
}