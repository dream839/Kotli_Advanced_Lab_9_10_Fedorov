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
# Galaxy Outpost Manager

Учебный проект на Kotlin, демонстрирующий основы объектно-ориентированного программирования и архитектурные приёмы языка.

---

## Sealed-классы

**Sealed-классы** используются для представления ограниченного набора состояний или результатов, которые известны на этапе компиляции.

Они позволяют:

- гарантировать обработку всех возможных вариантов;
- безопасно использовать конструкцию `when` без `else`;
- удобно описывать состояния, события и результаты действий.

### Пример: результат работы модуля

```kotlin
sealed class ModuleResult {
    data class Success(val message: String) : ModuleResult()
    data class ResourceProduced(
        val resourceName: String, 
        val amount: Int
    ) : ModuleResult()
    data class NotEnoughResources(
        val resourceName: String,
        val required: Int,
        val available: Int
    ) : ModuleResult()
    data class Error(val reason: String) : ModuleResult()
}
```
## Object в Kotlin
**object** — это специальная конструкция Kotlin, которая создаёт единственный экземпляр класса (Singleton).
### Особенности:
 - создаётся при первом обращении;
 - существует в одном экземпляре;
 - не имеет конструктора.
### Пример: глобальный логгер
```kotlin
object Logger {
private var counter = 0
    fun log(message: String) {
    counter++
    println("[$counter] $message")
    }
}
```

### Использование:
- Logger.log("Инициализация системы")
- Logger.log("Модуль запущен")
### object удобно использовать для:
- логгеров;
- конфигураций;
- состояний без данных в sealed-классах;
- утилитарных классов.
---
## Делегирование
Делегирование свойств позволяет передать логику хранения и обработки значения другому объекту.
### В Kotlin это реализуется с помощью ключевого слова by.
### Преимущества:
- уменьшение дублирования кода;
- централизованная логика проверки и обработки данных;
- более чистый и читаемый код.
### Пример: ограничение диапазона значения энергии
```kotlin
var energy: Int by Delegates.observable(100) { _, old, new ->
println("Энергия изменилась: $old → $new")
}
```
---
## Lazy (ленивая инициализация)
lazy позволяет инициализировать объект только при первом обращении к нему.
### Это полезно, если:
- объект создаётся не всегда;
- его создание ресурсоёмкое;
- нужно отложить инициализацию.
### Пример:
```kotlin
val resourceManager by lazy {
ResourceManager()
}
```
---
## Объект ResourceManager будет создан только при первом использовании.
Observer-паттерн (наблюдатель)
Observer-паттерн позволяет объектам реагировать на изменения состояния другого объекта.
### В проекте Galaxy Outpost Manager наблюдатели могут:
- реагировать на изменение ресурсов;
- логировать события;
- уведомлять пользователя.
### Пример идеи:
- ResourceManager изменяет ресурсы;
- наблюдатель выводит сообщение в консоль при изменении.
---
## Сохранение состояния Для сохранения состояния проекта используется сериализация в JSON.
### Это позволяет:
- сохранять данные между запусками программы;
- хранить состояние в человекочитаемом формате;
- легко перенести логику в Android-приложение.
---
## Автор
[Федоров Михаил Дмитриевич]
## Лицензия
Проект создан в учебных целях.