package ep1

fun sum(a:Int,b:Int,term:(Int)->Int):Int {
    var sum = 0
    for (i in a..b) {
        sum += term(i)
    }
    return sum
}

fun main() {

    // 高阶函数求平方
    val square = {x : Int -> x * x}
    // 高阶函数求立方
    val cube = {x : Int -> x * x * x}

    println(sum(1,10){
        x : Int -> x
    })
    println(sum(1,10, square))
    println(sum(1,10, cube))
}