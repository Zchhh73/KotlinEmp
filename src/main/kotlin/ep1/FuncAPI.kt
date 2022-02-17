package ep1

fun main() {
    // ::println方法引用
    // filter: 过滤器
    listOf(4, 6, 15, 21).filter { it > 10 }.forEach(::println)
    // map:
    listOf("java", "kotlin", "scala", "go").map { it.uppercase() }.forEach(::println)
    // flatMap:遍历所有元素，为每个元素创建集合，最后把所有集合放到一个集合中
    val newList = listOf(5, 8, 11, 14).flatMap { listOf(it, it + 1, it + 2) }
    println(newList)
    // Sequence
    sequenceOf(5, 12, 8, 33).filter { it > 10 }.forEach(::println)
    sequenceOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).map { it * 2 }.filter { it % 3 == 0 }.map { it + 1 }.forEach(::println)
    listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).map { it * 2 }.filter { it % 3 == 0 }.map { it + 1 }.forEach(::println)
}