import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val n = nextInt()
    val parent = MutableList(n) { -1 }
    val children = MutableList<MutableList<Int>?>(n) { mutableListOf() }

    for (i in 0 until n) {
        val p = nextInt()
        parent[i] = p
        if (p >= 0) {
            children[p]!!.add(i)
        }
    }

    val except = nextInt()

    deleteRecursively(children, except)

    var result = 0

    children.forEach {
        if (it != null && it.isEmpty()) {
            result++;
        }
    }

    if (parent[except] >= 0 && children[parent[except]]!!.count() == 1) {
        result++
    }

    println(result)
}

fun deleteRecursively(list: MutableList<MutableList<Int>?>, n: Int) {
    list[n]?.forEach { deleteRecursively(list, it) }
    list[n] = null
}