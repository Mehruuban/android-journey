package inheritance

fun main (){
    val child = Child()

}

open class  Parent{

    init {
        println("Parent class is called")
    }

    val name : String = ""
    fun method1 (){
        println("i am in parent class ")
    }
}

class Child : Parent() {

    init {
        println("Child class is called")
    }

    val naam: String = ""

    fun method2(){
        println("I am in child class ")
    }
}