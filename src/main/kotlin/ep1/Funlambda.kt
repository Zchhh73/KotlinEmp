package ep1

fun main() {

    /**
     * 在函数中，最后一个参数是函数类型，那么可以将 Lambda 可以移到函数的括号外面。
     * 如果函数的参数只有一个 Lambda ，那么函数的小括号可省略。
     * 在 Lambda 表达式中只有一个参数，可以使用默认参数 it 进行替代。
     * 对于有多个参数的 Lambda 表达式，如果某个参数未使用，可以用下划线("_")取代其名称
     * 入参、返回值与形参一致的函数，可以用方法引用的方式作为实参传入。
     */
    // lambda thread
    Thread {
        print("test")
    }.start()
    print("main")
}