#include <iostream>
#include <algorithm>
#include <set>
using namespace std;

int calc(int *bg, int *ed, int t) {
    if (bg == ed) return 0;
    int *max = max_element(bg, ed);

    if (bg == max) return (t - *max) + calc(max+1, ed, *max);
    else if (ed-1 == max) return (t - *max) + calc(bg, max, *max);
    else {
        return (t - *max) + calc(bg, max, *max) + calc(max+1, ed, *max);
    }
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int N, M;
    cin >> N >> M;
    set<int> s;
    int n;
    int ansAssumed;
    int ans = N * M;
    int inputs[N];

    for (int i = 0; i < N; i++) {
        cin >> n;
        s.insert(n);
        inputs[i] = n;
    }

    for (auto iter = s.begin(); iter != s.end(); iter++) {
        ansAssumed = *iter;
        int list[N];
        for (int i = 0; i < N; i++) {
            list[i] = inputs[i] > ansAssumed ? inputs[i] - M : inputs[i];
        }
        ans = min(ans, calc(list, list+N, ansAssumed));
    }

    cout << ans;

    return 0;
}