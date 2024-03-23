import java.lang.Integer.min
import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt()
    val M = nextInt()

    val board = MutableList(N) { "" }
    repeat(N) { r ->
        board[r] = next()
    }

    var res = 32

    for (r in 0 .. N-8) {
        for (c in 0 .. M-8) {
            var count = 0;
            for (x in 0 until 8) {
                for (y in 0 until 8) {
                    if ((x+y) % 2 == 1) {
                        if (board[r+x][c+y] == 'B') {
                            count++
                        }
                    } else {
                        if (board[r+x][c+y] == 'W') {
                            count++
                        }
                    }
                }
            }
            if (count > 32) count = 64 - count
            res = min(res, count)
        }
    }

    println(res)
}