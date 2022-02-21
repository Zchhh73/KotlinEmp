package ep1

import java.util.*

fun main() {
    val u1 = "tony"
    val u2 = "zch"
    val u3 = "haha"

    val user = listOf(u1,u2,u3)
    Collections.sort(user) { o1, o2 ->
        o1.compareTo(o2)
    }
    println(user.toString())
}