package example

var age: Int = 18
    set(value) {
        if ((value > 0) and (value < 110))
            field = value
    }
//fun main() {
//    println(example.age)
//    example.age = 45
//    println(example.age)
//    example.age = -345
//    println(example.age)
//}
data class Item(
    val id: Int,
    val name: String,
    val quantity: Int
){
    override fun toString(): String {
        return "Id предмета: $id\nИмя: $name\nКоличество: $quantity\n"
    }
}
abstract class Human(val name: String){
    abstract var age: Int

    abstract fun hello()
}
class Person(name: String, override var age: Int): Human(name){
    override fun hello() {
        println("My name is $name")
    }
}

fun main(){
    /*
    val sword = example.Item(1,"Sword",1)
    val betterSword = sword.copy(quantity = 2)
    println(sword.toString())
    println(betterSword.toString())
    val(id, name, quantity) = betterSword
    println("Id предмета: $id\nИмя: $name\nКол-во: $quantity")*/
//    val misha: example.Human
//    val pavel: example.Human = example.Human("Pavel")
    val misha: Person = Person("Misha", 18)
    val maksim: Human = Person("Maksim", 20)
    misha.hello()
    maksim.hello()
}