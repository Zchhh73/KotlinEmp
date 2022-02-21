package ep3


fun nonInlined(block: () -> Unit) {
    block()
}

inline fun inlined(block: () -> Unit) {
    block()
}

fun main(args: Array<String>) {
    nonInlined {
        println("nonInlined！")
    }
    inlined {
        println("Inlined！")

    }

}