fun main() {

    val isRaining = false

    if (isRaining){
        println("stay home")
    }
    else{
        println("enjoy the day")
    }

    val x = 10
    val y = 20

    if (x>y){
        println("x is greater than y")
    }
    else{
        println("y is greater than x ")
    }


    // expression in kotlin

    val number = 25

    val result = if (number % 2 == 0){
        "Even"
    }
    else{
        "odd"
    }
    println(result)
}