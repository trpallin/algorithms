import java.util.Scanner

val table = MutableList(30) { MutableList(30) { -1 } }

fun getComb(m: Int, n: Int): Int {
    if (n == 0) return 1
    if (n == 1) return m
    if (n > m/2) return getComb(m, m-n)
    if (table[m][n] == -1) {
        table[m][n] = getComb(m-1, n-1) + getComb(m-1, n)
        return table[m][n]
    }
    return table[m][n]
}

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val T = nextInt()
    val res = MutableList(0) { 0 }
    var N: Int
    var M: Int

    repeat(T) {
        N = nextInt()
        M = nextInt()
        res.add(getComb(M, N))
    }

    repeat(T) {
        println(res[it])
    }
}