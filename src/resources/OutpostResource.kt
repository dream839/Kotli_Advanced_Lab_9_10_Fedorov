package resources

import kotlin.properties.Delegates

data class OutpostResourse(
    val id: Int,
    val name: String,
    var amountInit: Int
) {
    var amount: Int by Delegates.observable(amountInit){
            _, old, new ->
        println("Ресурс [$name] изменился: $old -> $new")
    }
}

fun main(){
    val gas = OutpostResourse(1,"Gas", 100)
    val mineral = OutpostResourse(2, "Minerals", 250)
    println("Успех! Вы добавили доп. кол-во минералов: " +
            "${mineral.amount + 50}")
    val bonusMineral = mineral.copy(3,"Mineral Bonus", amountInit = mineral.amount + 50)
    println(gas.toString())
    println(mineral.toString())
    println(bonusMineral.toString())
}
