import javax.annotation.processing.Messager
import javax.print.DocFlavor

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
fun main(){
    println(hello(b = 10))
}
fun hello(a: Int = 10, b: Int = 20): Int{
    val c :Int = a+b
    return c
}