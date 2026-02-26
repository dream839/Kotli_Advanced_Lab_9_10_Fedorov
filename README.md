# Лабораторная работа №9-10: Продвинутое ООП на Kotlin
## Описание
Лабораторная работа посвящена изучению продвинутых концепций объектно-ориентированного
программирования в Kotlin.
## Структура проекта
Проект содержит примеры реализации продвинутых механизмов ООП, а также пояснения к ключевым
концепциям.
## Как запустить проект
1. Клонируйте репозиторий:
```bash
git clone <https://github.com/dream839/Kotli_Advanced_Lab_9_10_Fedorov.git>
```
2. Откройте проект в IntelliJ IDEA.
3. Запустите любой пример через контекстное меню или напрямую из `main`.
## Автор
Федоров М. Д.
## Лицензия
Проект создан 
# Основные концепции Kotlin

В этом файле собраны примеры и описание ключевых тем, которые мы изучили: инкапсуляция, геттеры/сеттеры, data-классы, абстрактные классы и интерфейсы.

---

### 5.Интерфейсы
Контракты поведения с возможностью default-реализаций.
```kotlin
// Простой интерфейс
interface Movable {
    val model: String
    var speed: Int
    
    fun move()
    fun stop() {
        println("Остановка...") // default реализация
    }
}
// Класс, реализующий интерфейс
class Car(override val model: String) : Movable {
    override var speed = 60

    override fun move() {
        println("Едем на машине $model со скоростью $speed км/ч")
    }
}

// Множественное наследование интерфейсов
interface Worker {
    fun work()
}

interface Student {
    fun study()
}

class WorkingStudent(val name: String) : Worker, Student {
    override fun work() = println("$name работает")
    override fun study() = println("$name учится")
}

// Конфликт имен методов в интерфейсах
interface VideoPlayable {
    fun play() {
        println("Play video")
    }
}

interface AudioPlayable {
    fun play() {
        println("Play audio")
    }
}

class MediaPlayer : VideoPlayable, AudioPlayable {
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}

// Функция, принимающая интерфейс
fun travel(obj: Movable) {
    obj.move()
    obj.stop()
}

// Пример использования
fun main() {
    val car = Car("Toyota")
    car.move()

    val student = WorkingStudent("Иван")
    student.work()
    student.study()

    val player = MediaPlayer()
    player.play()

    // Полиморфизм
    travel(car)
}
```