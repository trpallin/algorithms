#include <iostream>
using namespace std;

int getDist(int *list, int size, int from, int to) {
    int min;
    int dist = 0;

    if (from <= to) {
        for (int i = from; i < to; i++) {
            dist += list[i];
        }
        min = dist;
        dist = 0;
        for (int i = 0; i < from; i++) {
            dist += list[i];
        }
        for (int i = to; i < size; i++) {
            dist += list[i];
        }
        if (min > dist) min = dist;
    } else {
        for (int i = to; i < from; i++) {
            dist += list[i];
        }
        min = dist;
        dist = 0;
        for (int i = 0; i < to; i++) {
            dist += list[i];
        }
        for (int i = from; i < size; i++) {
            dist += list[i];
        }
        if (min > dist) min = dist;
    }
    return min;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int n, m, idx;
    int curr = 1;
    int res = 0;
    cin >> n >> m;
    int *list = new int[n];
    for (int i = 0; i < n; i++)
        list[i] = 1;
    for (int i = 0; i < m; i++) {
        cin >> idx;
        res += getDist(list, n, curr-1, idx-1);
        list[idx-1] = 0;
        curr = idx;
    }
    cout << res;
    return 0;
}