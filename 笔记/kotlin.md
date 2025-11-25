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

#### 再谈变量

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