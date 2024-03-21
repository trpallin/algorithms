#include <iostream>
#include <cmath>
using namespace std;

#define MAX_N 40
#define UNDEFINED -1

int getNum0(int N, unsigned int *table) {
    if (table[N] != UNDEFINED) return table[N];
    else {
        int entry = getNum0(N-1, table) + getNum0(N-2, table);
        table[N] = entry;
        return entry;   
    }
}

int getNum1(int N, unsigned int *table) {
    if (table[N] != UNDEFINED) return table[N];
    else {
        int entry = getNum1(N-1, table) + getNum1(N-2, table);
        table[N] = entry;
        return entry;
    }
}

void initTable(unsigned int *table) {
    for (int i = 0; i < MAX_N+1; i++) {
        table[i] = UNDEFINED;
    }
}

int main() {
    int T, N;
    unsigned int *result;
    unsigned int *table0, *table1;
    cin >> T;
    result = new unsigned int[2*T];
    table0 = new unsigned int[MAX_N+1];
    table1 = new unsigned int[MAX_N+1];

    initTable(table0);
    initTable(table1);
    table0[0] = 1;
    table0[1] = 0;
    table1[0] = 0;
    table1[1] = 1;

    for (int i = 0; i < T; i++) {
        cin >> N;
        result[2*i] = getNum0(N, table0);
        result[2*i+1] = getNum1(N, table1);
    }

    for (int i = 0; i < T; i++) {
        cout << result[2*i] << " " << result[2*i + 1] << "\n";
    }

    delete[] result;
    return 0;
}