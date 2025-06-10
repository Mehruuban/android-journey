fun main (){

    for (i in 1..10){
        println(i)
        // in this code  upper bound is included
    }

    println("")
    for (i in 1 until 10){
        println(i)
        // in this code the  upper bound is not included
    }

    println("")
    val fruit = listOf("mango","apple","banana")
    for (fruits in fruit){
        println("i like $fruits")
    }

    println("")

    for (i in 5 downTo 1){
        println(i)
    }
    println("")

    for (i in 1..10 step 2){
        println(i)
    }

    println("")

    // print Table of 10

    val  number = 10
    for (i in 1..10){
        println(number*i)
    }

    println("")

    /*
    print table like
    2 * 1 = 2
    2 * 2 = 4 etc
     */

    val table = 2
    for (i in 1..10){
        //println(table.toString() + " x " + i +  " = " + (table*i))
        // string templating
        println("$table x $i = ${table * i }")
    }

}
