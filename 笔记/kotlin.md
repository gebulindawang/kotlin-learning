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

```
fun main() {
    for (i in 1..10 step 2) {
        println(i)
    }
}
```



### 倒序遍历

如果需要倒着进行遍历，我们可以将 `..` 替换成 `downTo` 来使用：

kotlin

```
fun main() {
    for (i in 10 downTo 1) {
        println(i)
    }
}
```



也可以结合步长：

kotlin

```
fun main() {
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
}
```