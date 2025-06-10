fun main() {

    //Arithmetic operators
    var i = 31
    var l = 2
    println(i+l)
    println(i*l)
    println(i.toFloat()/l) // converted to float
    println(i-l)
    println(i%l)

    //Relational operators
    var a = 20
    var b = 2

    println(a>b)
    println(a<b)
    println(a>=b)
    println(a<=b)
    println(a!=b)


    //Logical operator

    val above75 = true
    val knowsCoding = true

    //&& AND

    var calledForInterView = above75 && knowsCoding
    println(calledForInterView)

    // || OR
    calledForInterView = above75 || knowsCoding
    println(calledForInterView)

}