import javax.annotation.processing.Messager
import javax.print.DocFlavor

fun main() {
    val student1 = Student("小明", 12)
    val student2 =!student1
    println(student2)
}

