package outpostState_DZ12

class ResourceObserver {
    fun onResourceChanged(resourceName: String, old: Int, new: Int) {
        println("Наблюдатель: ресурс '$resourceName' изменился с $old на $new")
    }
}