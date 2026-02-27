package outpostState_DZ12

class OutpostManager {
    val resources: List<ObservableResource> by lazy {
        println("Создание менеджера...")
        listOf(
            ObservableResource("Minerals", 100),
            ObservableResource("Gas", 50),
            ObservableResource("Energy", 200)
        )
    }
}