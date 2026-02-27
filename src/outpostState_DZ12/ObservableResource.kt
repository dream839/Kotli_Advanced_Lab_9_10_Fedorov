package outpostState_DZ12

import outpostState_DZ12.ResourceObserver
import kotlin.properties.Delegates

class ObservableResource(
    val name: String,
    initialAmount: Int
) {
    private val observer = ResourceObserver()

    var amount: Int by Delegates.observable(initialAmount) { property, old, new ->
        println("Ресурс $name изменён: $old → $new")
        observer.onResourceChanged(name, old, new)
    }
}