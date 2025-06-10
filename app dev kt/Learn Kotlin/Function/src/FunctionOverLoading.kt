fun main (){
    println(addition(100,232))
    println(addition(10.5,2.5))

    // named Arguments
    println(addition(a = 5 , b = 5))
    println(addition(a = 50 , b = 50))
}

fun addition (a: Int ,b: Int) : Int{
    return  a+b
}

fun addition(a : Double , b: Double) : Double{
    return a+b
}
