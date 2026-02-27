package outpostState_DZ12

import outpostState_DZ12.OutpostManager

fun main() {
    val manager = OutpostManager()

    println("Обращение к менеджеру...")
    val resources = manager.resources

    println("\nИзменение ресурсов:")
    resources[0].amount = 120
    resources[1].amount = 75
    resources[2].amount = 180

    println("\nСохранение состояния...")
    StateStorage.saveResources(resources)

    println("\nЗагрузка состояния...")
    val loadedResources = StateStorage.loadResources()

    println("\nЗагруженные ресурсы:")
    loadedResources.forEach {
        println("${it.name}: ${it.amount}")
    }
}