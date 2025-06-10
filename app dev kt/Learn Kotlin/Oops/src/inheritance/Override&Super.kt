package inheritance

fun main (){

    var car = Car("White")
    println(car.name)
    car.drive()
}

open class  Vehicle (var vehicleColor: String) {
    init {
        println("Parent class is called")
    }

    open var name: String = "Vehicle"      //  To override this property   (name)   in child class   , we need to open this property   and same for function
     open  fun drive(){
        println("Vehicle is running ")
    }
}

class  Car (var carColor: String): Vehicle(carColor) {
    init {
        println("The child class is called ")
    }
    override var name = "Car"
     override  fun drive (){
         super.drive()           // here Super keyword is helps to calls the function of Parent class
        println("this is car ")
    }

    



}