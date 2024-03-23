import java.util.Scanner
import kotlin.math.max

fun click(lamps: MutableList<MutableList<Boolean>>, col: Int) {
    for (r in 0 until lamps.size) {
        lamps[r][col] = !lamps[r][col]
    }
}

fun count(lamps: MutableList<MutableList<Boolean>>): Int {
    var count = 0
    for (r in 0 until lamps.size) {
        if (lamps[r].all { it }) count++
    }
    return count
}

fun solve(lamps: MutableList<MutableList<Boolean>>, current: Int, clickLeft: Int): Int {
    if (clickLeft == 0) {
        return count(lamps)
    }
    if (clickLeft > lamps[0].size) {
        return if ((clickLeft % 2) != (lamps[0].size % 2)) solve(lamps, current, lamps[0].size - 1)
        else solve(lamps, current, lamps[0].size)
    }
    if (lamps[0].size - current == clickLeft) {
        for (c in lamps[0].size - current until lamps[0].size) {
            click(lamps, c)
        }
        return count(lamps)
    }
    val a = solve(lamps, current+1, clickLeft)
    click(lamps, current)
    return max(a, solve(lamps, current+1, clickLeft-1))
}

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt()
    val M = nextInt()
    val lamps = MutableList(N) { MutableList(M) { false } }
    for (r in 0 until N) {
        val row = next()
        for (c in 0 until M) {
            lamps[r][c] = row[c] == '1'
        }
    }
    val click = nextInt()

    println(solve(lamps, 0, click))
}