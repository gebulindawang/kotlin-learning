import javax.naming.Name
open class Student{
    var name: String = "小明"
    fun sayHello(){
        println("hello, my name is $name")
    }
}
open class artStudent:Student(){
     fun test(){
        sayHello()
     }
}


