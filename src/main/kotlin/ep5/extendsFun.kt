package ep5

// 扩展函数

fun String.padding(count: Int, char: Char = ' '): String {
    val padding = (1..count).joinToString("") { char.toString() }
    return "${padding}${this}${padding}"
}

fun String.times(count: Int): String {
    return (1..count).joinToString(""){this}
}


fun main() {
    println("zch".padding(10))

    println("*".times(10))
}