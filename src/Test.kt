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