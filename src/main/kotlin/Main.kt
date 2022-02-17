
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking


@ExperimentalStdlibApi
suspend fun foo() : List<String> = buildList {
    println("Zchhh发送数据")
    delay(1000)
    add("A")
    delay(1000)
    add("B")
    delay(1000)
    add("C")
    println("Zchhh结束发送数据")
}

suspend fun foo2() : Flow<String> =  flow {
    println("Zchhh发送数据")
    delay(1000)
    emit("A")
    delay(1000)
    emit("B")
    delay(1000)
    emit("C")
    println("Zchhh结束发送数据")
}

suspend fun foo3() : Channel<String> {
    val channel = Channel<String>()
    println("Zchhh发送数据")
    delay(1000)
    channel.send("A")
    delay(1000)
    channel.send("B")
    delay(1000)
    channel.send("C")
    println("Zchhh结束发送数据")
    return channel
}

@ExperimentalStdlibApi
fun main() = runBlocking {
    val channel = foo3()
    while (true) {
        println("initData: ${channel.receive()}")
    }
}