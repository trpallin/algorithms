#include <iostream>
#include <algorithm>
using namespace std;

#define INPUT_LIMIT 1001

int main() {
    int N;

    cin >> N;

    int result[N];

    pair<int, int> p[N];

    for (int i = 0; i < N; i++) {
        p[i].first = i;
        cin >> p[i].second;
    }

    sort(&p[0], &p[N-1]+1, [](auto &left, auto &right) {
        return left.second == right.second ? left.first < right.first : left.second < right.second;
    });

    for (int i = 0; i < N; i++) {
        result[p[i].first] = i;
    }

    for (int i = 0; i < N; i++) {
        cout << result[i] << " ";
    }

    return 0;
}