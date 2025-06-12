fun main (){
    val result = add(5,5) //arguments
    println(result)

    val  multiply = multiplication(5,10)
    println(multiply)

    evenOrOdd(20)
    evenOrOdd(33)

}

fun add (num1: Int , num2: Int): Int { // parameters
    val  sum = num1 + num2
    return sum
}

fun multiplication (num1: Int , num2: Int) : Int  {
    val multiplication = num1 * num2
    return multiplication
}
   //let's check the number is even or odd
fun evenOrOdd (num1 : Int){
    val mehru  = if (num1 % 2 ==0) "Even" else "Odd"
    println(mehru)
}