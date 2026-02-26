package example

interface Movable {
    val model: String
    val number: String
    var speed: Int
    fun move()
    fun stop(){
        println("Останавливаемся...")
    }
}
class Car(override val model: String,
          override val number: String)
    : Movable {
    override var speed = 60
    override fun move(){
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft(override val model: String,
               override val number: String)
    : Movable{
    override var speed = 600
    override fun move(){
        println("Летим на самолете со скоростью $speed")
    }
    override fun stop() = println("Приземлямся...")
}
fun travel (obj: Movable) = obj.move()

interface Worker{
    fun work()
}
interface Student{
    fun study()
}
class WorkingStudents(val name: String) : Worker, Student{
    override fun work() = println("$name работает")
    override fun study() = println("$name учится")
}

interface VideoPlayable {
    fun play() = println("Play video")
}
interface AudioPlayable {
    fun play() = println("Play audio")
}
class MediaPlayer : VideoPlayable, AudioPlayable{
    override fun play(){
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}