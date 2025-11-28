# Kotlin程序设计初级篇

## 变量的声明与使用

要声明一个变量，我们需要以下格式：

kotlin

```
var [变量名称] : [数据类型]
```



字符串拼接只需要使用 `$变量名` 或 `${表达式}` 就可以了。

示例：

kotlin

```
var name: String = "Kotlin"
var age: Int = 10
println("Hello, $name! You are $age years old.")
```



## 循环语句

### 基本for循环

kotlin

```
for (遍历出来的单个目标变量 in 可遍历目标) {
    // 循环体
}
```



### 步长控制

默认情况下，每一轮的循环都会向后+1，我们也可以自由控制每一轮增加多少，也就是步长：

kotlin

```kotlin
fun main() {
    for (i in 1..10 step 2) {
        println(i)
    }
}
```



### 倒序遍历

如果需要倒着进行遍历，我们可以将 `..` 替换成 `downTo` 来使用：

kotlin

```kotlin
fun main() {
    for (i in 10 downTo 1) {
        println(i)
    }
}
```



也可以结合步长：

kotlin

```kotlin
fun main() {
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
}
```



创建和使用函数

kotlin函数使用fun关键字声明：

```kotlin
fun 函数名称([函数参数...]):返回值类型{
//函数体
}
```

有些时候，我们也可以设计一些参数带有默认值的函数，如果调用函数时不填入参数，那么我们一开始设置好的默认值作为实际传入的参数：

```kotlin
fun main(){
test()
}
fun test(text : String = "我是默认值"){
	println(text)
}
```

在调用函数时，我们可以手动指定传入的参数对应的是哪一个形式参数：

```kotlin
fun main(){
test(b=3)//如果只想填写第二个参数b，我们可以直接把实参给到哪一个形参
test(3)这种情况就是只填入第一个实参
}
fun test(a:Int = 6,b:Int = 10):Int{
return a + b;
}
```

对于一些内容比较简单的函数，比如上面仅仅是计算两个参数的和，我们可以直接省略花括号

```kotlin
fun test(a:Int = 6,b:Int = 10):Int = a + b
fun test(a:Int = 6,b:Int = 10) = a + b
```

kotlin内部也可以定义函数，函数内的函数作用域是受限的，我们只能在函数内部使用

kotlin也支持重载

### 再谈变量

我们可以将变量的作用域进行提升，将其直接变成一个顶级定义

```kotlin
var str : String = '123'
fun main(){
...
}
```

此时这个变量可以被所有函数使用

其实，声明一个变量的完整语法如下：

```
var <propertyName>[: <PropertyType>] [= <property_initializer>]
[<getter>]
[<setter>]
```

在使用这种全局变量时，对于变量的获取和设定，本质上都是通过getter和setter函数来完成的，只不过默认情况下不需要我们去编写 

# 高级函数和lambda表达式

kotlin中函数为一等公民，支持很多高级特性，甚至可以被存储在变量里面，可以作为参数传递给其他高阶函数并从中返回。

```kotlin
//表示一个String作为参数，返回值为int类型的函数
val func :(String) ->Int = {1}
```

```kotlin
fun test(func :(String) ->Int){}
```

## Lambda表达式

```kotlin
fun main(){
var func:(String) ->Int ={ //一个lambda表达式只需要直接在花括号中编写函数体即可
println(it) //默认情况下，如果函数只有一个参数，我们可以用it代替传入的参数
666//默认最后一行为返回值
	}
}
```

如果参数有多个，我们也可以这样写

```kotlin
fun main(){
var func:(String,String) ->Int ={ a,b->
println(a,b) //
666//默认最后一行为返回值
	}
}
```

```kotlin
fun main() {
    test {
        println(it);
        123
    }
}
fun test(func:(String) -> Int){
    println(func("hello"))
}
```

man函数调用test函数，lambda表达式作为函数参数传入test函数里面。而test函数里执行println 接受的func函数。func函数此时就是传入的lambda表达式，所以先打印传入的参数hello（it），然后最后打印返回值123

lambda表达式本质上就是一个匿名函数，并且lambda表达式没有办法直接使用return语句返回结果，而是需要特殊标签

```kotlin
fun main() {
    val func:(Int) -> String = test@{
        if (it > 10){
            return@test "我是提前返回值"
        }
        "我是默认返回值"
    }
    print(func(11))
}
```

## 内联函数

使用高阶函数可能会影响运行时的性能：每个函数都是一个对象，而且函数内可以访问一些局部变量，但是这可能会再内存分配（用于旱函数对象和类）和虚拟调用时造成额外的开销

为了优化性能，开销可以使用内联Lambda表达式来消除。使用inline关键字会影响函数本身和传递给它的lambdas，它能够让方法调用在编译时，直接替换为方法的执行代码，

```kotlin
fun main(){
	test()
}
//添加inline表示内联函数
inline fun test(){
	println("这是一个内联函数")
	println("这是一个内联函数")
	println("这是一个内联函数")
}
```

由于test函数是内联函数，在编译之后，会原封不动的把代码搬过去

```kotlin
fun main(){
	println("这是一个内联函数")
	println("这是一个内联函数")
	println("这是一个内联函数")
}
```

注意：内联函数的函数形参，无法作为值给到变量，只能调用

# 对象的创建与使用

kotlin类的属性定义一般使用构造函数使用

主构造函数：可以直接在主构造函数中定义类属性，使用更加方便，但是主构造函数只能存在一个，并且无法编写函数体，只有为类属性做初始化赋值的效果

辅助（次要）构造函数：可以存在多个，并且可以使用自定义函数体，但是无法像主构造函数那样定义类属性，并且当类具有主构造函数时，所有次要构造函数必须直接或间接地调用主构造函数

kotlin语言比较灵活，类中并不是一定需要主构造函数，全部写辅助构造函数也是可以的。但是再怎么都得有构造函数
