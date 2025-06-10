fun main(){

    var car = autoMobile("bmw","Petrol", 5)

    var person = person("Meharban ", 20)
    var person2 = person ("mehru",15)

    println(person.name)
    println(person.age)

    println(person2.name)
    println(person2.age)

}


    // Primary constructor
class  autoMobile (var name : String , var type: String , var seating : Int){

    fun drive(){}

    fun  CanBreake(){}
}

class  Person (nameParam: String , ageParam: Int)  {
    var naam = nameParam
    var age = ageParam

}