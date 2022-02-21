package ep4

fun main() {
    val result = "hello".apply {
        println("$this world")
        this + "world"
    }
    println(result)

    val result2 = "hello".run {
        println("$this Zchhh")
        "$this Zchhh"
    }
    println(result2)
}