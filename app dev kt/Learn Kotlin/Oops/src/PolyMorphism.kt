fun main (){
    var animals : List<Animal> = listOf(Cat(),Dog(),Lion1())

    for (animal in animals){
        animal.makeSounds()
    }
}

open  class Animal {
    open  fun makeSounds(){
        println("Animal makes sounds")
    }
}


class Cat:Animal() {
   override fun makeSounds(){
        println("The sound of make cat is meao meao")
    }
}

class Dog :Animal(){
    override fun makeSounds(){
        println("Dog is barking like bhow bhow")
    }
}

class Lion1 :Animal(){
    override fun makeSounds() {
        println("Lion Make sound like .....")
    }
}