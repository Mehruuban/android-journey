fun main() {
    val arr = arrayOf("one","two","three")
    for (i in arr){
        println(i)
    }

    println("")
    val fruits = arrayOf("Banana" , "Apple" , "Mango")

    for (fruit in fruits) {
        println(fruit)
    }

println("")

    // To show with index
    val number = arrayOf(1,2,"Mango",4,5,"Apple",7,8,9,10,11,12,13,14,15)
    for ((num,e) in number.withIndex()){
        println("$num - $e")
    }

    println("")

    // To access particular element of created array for that
    println(number[2])
    //Or
    println(number.get(5))

    // also we can set or change the value of particular element like

    number.set(5,"Hey Meharban ")
    println(number[5])

    // To access the size of array for that

    println(number.size)
    println(number[10])

}