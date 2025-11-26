import javax.annotation.processing.Messager
import javax.print.DocFlavor

fun main() {
    val func:(Int) -> String = func@{
        if (it > 10){
            return@func "我是提前返回值"
        }
        "我是默认返回值"
    }
    print(func(11))
}
fun test(func:(String) -> Int){
    println(func("hello"))
}