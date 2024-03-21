#include <iostream>
#include <cmath>
using namespace std;

class Node {
public:
    Node(int dt) {
        depTo = dt;
    }
    int depTo;
    Node *next;
};

int getTime(Node **nodes, int n, int *times, int *table) {
    Node *node = nodes[n];
    if (table[n] != -1) {
        return table[n];
    }
    if (node == nullptr) {
        table[n] = times[n];
        return times[n];
    }
    int maxTime = 0;
    int time;
    Node *iter;

    for (iter = node; iter != nullptr; iter = iter->next) {
        time = getTime(nodes, iter->depTo - 1, times, table);
        if (maxTime < time) {
            maxTime = time;
        }
    }

    table[n] = times[n] + maxTime;

    return times[n] + maxTime;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

    int T, N, K, W;
    int i;
    int *ans;
    int from, to;

    cin >> T; // number of test cases
    ans = new int[T];
    

    for (int j = 0; j < T; j++) {
        cin >> N >> K; // N: number of buildings, K: number of rules

        int times[N];
        Node *dep[N];
        int table[N];

        for (i = 0; i < N; i++) {
            dep[i] = nullptr;
            table[i] = -1;
        }

        for (i = 0; i < N; i++) {
            cin >> times[i];
        }

        for (i = 0; i < K; i++) {
            cin >> from >> to;
            Node *newNode = new Node(from);
            newNode->next = dep[to-1];
            dep[to-1] = newNode;
        }

        cin >> W;

        ans[j] = getTime(dep, W-1, times, table);
    }

    for (i = 0; i < T; i++) {
        cout << ans[i] << "\n";
    }

    delete[] ans;

    return 0;
}