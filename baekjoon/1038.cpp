#include <iostream>
#include <cmath>
using namespace std;

int getCombOf10(int n) {
    if (n > 5) return getCombOf10(10 - n);

    switch (n) {
        case 0:
            return 1;
        case 1:
            return 10;
        case 2:
            return 45;
        case 3:
            return 120;
        case 4:
            return 210;
        case 5:
            return 252;
        default:
            return 0;
    }
}

long long getMinNum(int dec) {
    long long res = 0;
    long long base = 1;
    for (int i = 0; i < dec; i++) {
        res += i * base;
        base *= 10;
    }
    return res;
}

long long getPowOf10(int n) {
    long long res = 1;
    while (n > 0) {
        res *= 10;
        n--;
    }
    return res;
}

long long getNextNum(long long n, int dec) {
    int curr, next;
    n++;
    for (int i = 1; i < dec; i++) {
        curr = n % getPowOf10(i) / getPowOf10(i-1);
        next = (n % getPowOf10(i+1)) / getPowOf10(i);
        if (curr >= next) {
            n += getPowOf10(i);
            n += (i-1-curr) * getPowOf10(i-1);
        }
    }
    return n;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int N;
    cin >> N;

    N = N + 1;
    
    int decimals = 1;

    while (N > getCombOf10(decimals) && decimals <= 10) {
        N -= getCombOf10(decimals);
        decimals++;
    }

    if (decimals > 10) {
        cout << -1;
    } else {
        long long res = getMinNum(decimals);
        while (N > 1) {
            res = getNextNum(res, decimals);
            N--;
        }
        cout << res;
    }
    
    return 0;
}