fun main(){
  var a = ABC("Mohammad",22)
    var b = ABC("Meharban" , 22)
    println(a.name)
    println(b.name)
    b.age = 23
    b.age = -23
}

class  ABC (nameParam : String ,ageParam: Int){
    var name : String = nameParam
        // for getter
        get() {
            return  field.uppercase()
        }


    var age : Int = ageParam
    // for Setter
        set(value) {
            if (value >0 ){
                field = value
            } else{
                println("age cant be negettive")
            }
        }


    // default constructor    kotlin can create by default constructor
        var email : String = ""
        get() = field
        set(value) {
            field  = value
        }


}



class  Calculator{
      // lateinit  in kotlin
    lateinit var message : String
    fun add(a : Int , b : Int) : Int {
        return a+b

    }

    fun multiply(a: Int, b: Int): Int{
        return  a *b

    }

}