import java.util.*

fun dfs(fields: Array<IntArray>, r: Int, c: Int) {
    if (r > 0 && fields[r-1][c] == 1) {
        fields[r-1][c] = 0
        dfs(fields, r-1, c)
    }
    if (r < fields.size-1 && fields[r+1][c] == 1) {
        fields[r+1][c] = 0
        dfs(fields, r+1, c)
    }
    if (c > 0 && fields[r][c-1] == 1) {
        fields[r][c-1] = 0
        dfs(fields, r, c-1)
    }
    if (c < fields[0].size-1 && fields[r][c+1] == 1) {
        fields[r][c+1] = 0
        dfs(fields, r, c+1)
    }
}

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val T = nextInt()
    var M: Int
    var N: Int
    var K: Int
    val res = MutableList(0) {0}

    repeat(T) {
        M = nextInt()
        N = nextInt()
        K = nextInt()

        val fields = Array(50) { IntArray(50) { 0 } }

        repeat(K) {
            val a = nextInt()
            val b = nextInt()
            fields[a][b] = 1
        }

        var count = 0

        for (r in 0 until M) {
            for (c in 0 until N) {
                if (fields[r][c] == 1) {
                    count++
                    fields[r][c] = 0
                    dfs(fields, r, c)
                }
            }

        }

        res.add(count)
    }

    repeat(T) {
        println(res[it])
    }
}