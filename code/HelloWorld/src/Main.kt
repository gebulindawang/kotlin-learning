import javax.annotation.processing.Messager
import javax.print.DocFlavor

var a = 10
    get() = field * 10
    set(value){
        println("我被赋值了")
       
    }
//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
fun main(){
    a=10
}