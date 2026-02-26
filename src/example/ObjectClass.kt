package example

object GameSession {
    init{
        println("Игровая сессия создана")
    }
    var isActive: Boolean = false
    fun start(){
        isActive = true
        println("Игра началась")
    }
    fun end(){
        isActive = false
        println("Игра завершена")
    }
}
object Logger {
    var count = 0

    fun log(message: String) {
        count++
        println("[$count] $message")
    }
}