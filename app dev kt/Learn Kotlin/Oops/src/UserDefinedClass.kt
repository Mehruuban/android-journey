fun main(){

    var i : Int = 20
    println(i.plus(30))
    println(i.toFloat())

    val a = mehru("Mehru", 12)
    var b = mehru("meharban", 50)
    println(a.canVote())
    println(b.canVote() )

    a.age = 40
    println(a.canVote())
}

class mehru (val name : String , var age: Int){   // properties

    // Functions or methods

    fun canVote (): Boolean{
        return  age>18
    }

}