# 扩展函数

### 一.介绍

扩展函数是形如`类名.方法名()`这样的形式。Kotlin 允许开发者在不改变已有类的情况下，为某个类添加新的函数，这个特性叫做扩展函数。

### 二.特性

* 当扩展函数和原先函数重名，且具有相同参数时，扩展函数会失效，调用原先类的函数。
* 多态性讨论：在Java中父类引用指向子类对象，调用方法时会调用子类的实现；而在kotlin中，最终执行的是父类的扩展函数，因此扩展函数不具备多态性。
* 扩展函数本质上并不是对原先的类新增一个方法，它是以静态导入的方式来实现的。
* Java 也能调用 Kotlin 的扩展函数，可以把它当成是一个工具类来使用。

### 三.扩展函数介绍

#### 1.with
with将某个对象作为函数的参数，在函数块内可以通过this指代该对象。在函数块内可以直接调用对象方法或属性。
~~~ kotlin
class AppPublisherAdapter : BaseAdapter<BoundAppInfoResponse.AppInfo>() {

    override fun getLayoutId(viewType: Int): Int = R.layout.cell_app_publisher

    override fun onBindViewHolderImpl(holder: BaseViewHolder, position: Int,content: BoundAppInfoResponse.AppInfo) {
        
        with(content) {
            holder.itemView.tv_game_name.text = name
            if (is_bound) {
                holder.itemView.tv_bound_user_name.text = bound_user_name
                holder.itemView.tv_bound_user_name.setTextColor(context.color(R.color.color_bound_user_name))
            } else {
                holder.itemView.tv_bound_user_name.text = context.string(R.string.bind_on_account)
                holder.itemView.tv_bound_user_name.setTextColor(context.color(R.color.color_bind_on_account))
            }
            holder.itemView.iv_game_icon.load(logo_url)
        }
    }
}
~~~

#### 2.apply
apply函数是指在函数块内可以通过`this`指代该对象，返回值为该对象自己。在链式调用中，我们可以考虑使用它，从而不用破坏链式。
~~~ kotlin
object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val result ="Hello".apply {
            println(this+" World")
            this+" World" // apply 会返回该对象自己，所以 result 的值依然是“Hello”
        }
        println(result)
    }
}
~~~

#### 3.run
run类似apply,但run返回的是最后一行的值。
~~~ kotlin
    val result2 = "hello".run {
        println("$this Zchhh")
        "$this Zchhh"
    }
    println(result2)
~~~

#### 4.let
let函数把当前对象作为闭包的`it`参数，返回值是函数里面最后一行，或者指定`return`。它看起来有点类似于`run`函数。
~~~ kotlin
    //obj不为null的情况下执行let函数块的代码，从而避免了空指针异常的出现。
    obj?.let{
    
    }
~~~

#### 5.also
also类似于apply,also在函数块内可通过`it`指代对象，返回值为该对象自己。
~~~ kotlin
object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val result ="Hello".also {
            println(it+" World")
            it+" World" 
        }
        println(result)
    }
}
~~~
