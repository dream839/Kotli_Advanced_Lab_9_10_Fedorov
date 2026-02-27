package outpostState_DZ12

import java.io.File

object StateStorage {
    private const val FILE_NAME = "resources_state"

    fun saveResources(resources: List<ObservableResource>) {
        val file = File(FILE_NAME)

        file.writeText(resources.joinToString("\n") {
            "${it.name}|${it.amount}"
        })

        println("Состояние сохранено в файл")
    }

    fun loadResources(): List<ObservableResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) return emptyList()

        println("Загрузка состояния из файла")

        return file.readLines().map {
            val (name, amount) = it.split("|")
            ObservableResource(name, amount.toInt())
        }
    }
}