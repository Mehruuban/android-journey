fun main(){

    val person = Person1("Mehru",20)
    println("name = ${person.name}")
    println("age = ${person.age}")

    val mm = meharban("Mehar ", 20)

    // object of automobile class
    val car = AutoMobile1("Benz","Petrol")
    println("")
    val car2 =AutoMobile1("BMW","Both petrol and diesel")
}
class Person1 (val name : String , var age : Int){

}


class  meharban (name : String , age : Int){
    var Firstname = name
    var personAge = age

    //initializer block
    init {
        Firstname = name.capitalize()
        personAge = age.plus(2)

        println("First name = $Firstname")
        println("Age = $personAge")
    }
}

    // secondary constructor
class AutoMobile1 (val name : String , val tyres: Int , val maxSeating: Int , val engineType: String){

    init {
        println("name of the car is :  $name")
    }
        init {
            println("Engine type of $name car is :  $engineType ")
        }
        init {
            println("Seating capacity of $name car is  :  $maxSeating")
        }

         /* in kotlin to create secondary constructor
          must call the primary constructor using :this keyword
           AND
           to initialize secondary constructor for that we are  using constructor keyword
           */

        constructor(carName:String, carEngine: String )
                :this(carName,4,5,carEngine)

    }