fun main(){

    // object of the class
    val object1 = person("Meharban",20)
    val object2 = person("Yasar", 17)

    object1.isAdult(20)
    object2.isAdult(17)
}

class  person (var name: String , var age : Int){

    fun isAdult(age: Int){
        if (age >= 18){
            println("hey $name you are adult ")
        } else {
            println("hey $name you are under 18")
        }
    }
}
