import example.OrderStatus
import example.handleOrder

fun main() {
//    val manager = ResourceManager()
//    manager.add(OutpostResourse(1, "Minerals", 120))
//    manager.add(OutpostResourse(2, "Gas", 40))
//    val generator = EnergyGenerator()
//    val lab = ResearchLab()
//    generator.performAction(manager)
//    lab.performAction(manager)
//    println()
//    manager.printAll()
//    val minerals = resources.OutpostResourse(1, "Minerals", 300)
//    val gas = resources.OutpostResourse(2, "Gas", 100)
//    manager.add(minerals)
//    manager.add(gas)
//    manager.printAll()
//    val bonus = minerals.copy(amount = minerals.amount + 50)
//    println("опия минералов с бонусами $bonus")
//    println("Программа запущена")
//    println("Проверяем состояние, но не трогаем GameSession")
//    println("Теперь запускаем игру")
//    GameSession.start()
//    println("Проверяем состояние ещё раз")
//    println("Активна ли сессия: ${GameSession.isActive}")
//    Logger.log("Первое сообщение")
//    Logger.log("Второе сообщение")
//    val logger1 = Logger
//    val logger2 = Logger
//    println(logger1 == logger2)
//    handleOrder(OrderStatus.Created)
//    handleOrder(OrderStatus.Paid)
//    handleOrder(OrderStatus.Shipped)
//    handleOrder(OrderStatus.Cancelled("Нет товара на складе"))
//    fun handleModuleResult(result: ModuleResult){
//        when (result){
//            is ModuleResult.Success ->
//                println("УСПЕХ: ${result.message}")
//            is ModuleResult.ResourceProduced ->
//                println("Произведено: ${result.resourceName} +${result.amount}")
//            is ModuleResult.NotEnoughResources ->
//                println("Недостаточно ресурса ${result.resourceName}. " +
//                "Нужно: ${result.required}, есть: ${result.available}")
//            is ModuleResult.Error ->
//                println("ОШИБКА: ${result.reason}")
//        }
//    }
//
//    println("Создаём профиль пользователя...")
//    val user = UserProfile("Misha", "FedorovAbd@example.com")
//    println("\nИмя: ${user.name}")
//    println("Email: ${user.email}")
//    println("\nОбращаемся к аватару впервые:")
//    println("Файл аватара: ${user.avatar}")
//    println("\nОбращаемся к аватару снова (должен быть взят из кэша):")
//    println("Файл аватара: ${user.avatar}")
//    println("\nМеняем email:")
//    user.email = "Mihail@example.com"
//    println("\nМеняем Name:")
//    user.name = "Fedorov M."