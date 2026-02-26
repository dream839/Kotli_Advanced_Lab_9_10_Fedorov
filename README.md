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

### Интерфейсы
Контракты поведения с возможностью default-реализаций.
```kotlin
// Простой интерфейс для животных
interface Animal {
    val name: String
    fun makeSound()
    fun sleep() {
        println("$name спит...") // реализация по умолчанию
    }
}

// Класс, реализующий интерфейс Animal
class Dog(override val name: String) : Animal {
    override fun makeSound() {
        println("$name говорит: Гав-гав!")
    }
}

// Множественное наследование интерфейсов
interface Carnivore {
    fun hunt()
}

interface Domesticated {
    fun feed()
}

class Wolf(val species: String) : Animal, Carnivore, Domesticated {
    override val name: String
        get() = "Волк $species" // пример получения имени

    override fun makeSound() {
        println("$name рычит.")
    }

    override fun hunt() {
        println("$name охотится в лесу.")
    }

    override fun feed() {
        println("$name ест мясо.")
    }
}

// Конфликт методов по имени
interface Flyable {
    fun fly() {
        println("Летать в небе.")
    }
}

interface Swimable {
    fun fly() {
        println("Плавает в воде.")
    }
}

class Duck : Flyable, Swimable {
    override fun fly() {
        println("Утка использует метод fly() для полета и плавания.")
        // Вызов методов из интерфейсов
        super<Flyable>.fly()
        super<Swimable>.fly()
    }
}

// Функция, принимающая интерфейс Animal
fun animalInfo(animal: Animal) {
    println("Информация о животном: ${animal.name}")
    animal.makeSound()
    animal.sleep()
}

// Основная функция
fun main() {
    val dog = Dog("Булька")
    dog.makeSound()
    dog.sleep()

    val wolf = Wolf("Серый")
    wolf.makeSound()
    wolf.hunt()
    wolf.feed()

    val duck = Duck()
    duck.fly()

    // Использование функции с интерфейсом
    animalInfo(dog)
    animalInfo(wolf)
}
```