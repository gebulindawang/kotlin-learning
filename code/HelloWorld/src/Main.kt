import javax.annotation.processing.Messager
import javax.print.DocFlavor

fun main() {
    val p1:Student = Student("张三", 18)
    val p2:Student = p1
    p2.name = "李四"
    println(p1.name)
}

