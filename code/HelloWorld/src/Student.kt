data class Student constructor (var name: String,var age: Int){
    operator fun not() = Student("我是取反后的名字",0)
    override fun toString(): String = "我的名字是$name,我的年龄是$age"
}