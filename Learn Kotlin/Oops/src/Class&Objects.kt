fun main() {

    val bmw = Car("bmw","petrol",1000)
    val oodi = Car ("oodi","petrol",3500)
    println(bmw.name)
    println(bmw.type)
    println(bmw.kmRun)

println("")

    println(oodi.name)
    println(oodi.type)
    println(oodi.kmRun)

    bmw.driveCar()
    bmw.applyBrakes()


}

class  Car (val name: String , val type : String , var kmRun : Int) // properties
 {

    fun driveCar (){  // Methods or function
        println("$name  Car is driving")
    }

    fun applyBrakes (){   // function or methods
        println("brake applied")
    }

}

 /*
   Note :

    The properties is storing our data and
    Methods or functions is normal function that work on the data
    */