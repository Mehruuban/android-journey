fun main (){
    val animal = Elephant()
    animal.makeSound()

    val animal2 = Lion()
    animal2.makeSound()
}


abstract  class  Animals (){
   val name : String = "Meharban"
   abstract fun makeSound()    // abstract method

    open fun sleep (){       // non-abstract method
        println("Animals can sleep ")
    }


}

class Elephant:Animals() {
    override fun makeSound(){
        println("Elephant make sounds")
    }

}

class Lion:Animals() {
    override fun makeSound(){
        println("Lion make sounds")
    }
}

