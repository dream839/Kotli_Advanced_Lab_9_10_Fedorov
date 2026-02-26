package resources
import resources.OutpostResourse
import resources.ResourceManager



class ResourceManager {
    private val resources = mutableListOf<OutpostResourse>()
    fun getAll(): List<OutpostResourse> = resources.toList()
    fun add(resource: OutpostResourse){
        resources.add(resource)
        println("Добавление ресурс: ${resource.name}")
    }
    fun get(name: String): OutpostResourse?{
        return resources.find {it.name == name}
    }
    fun printAll(){
        println("Ресурсы базы")
        resources.forEach { println("${it.name}: ${it.amount}")}
    }


}