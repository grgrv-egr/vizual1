import kotlin.random.Random
import kotlin.math.*
import kotlin.concurrent.thread

open class Human {
    var name: String = ""
    var surname: String = ""
    var second_name: String = ""
    var age: Int = 0
    var currentSpeed: Int = 0
    var x: Int = 0
    var y: Int = 0

    constructor(_name: String, _surname: String, _second: String, _age: Int, _speed: Int){
        name = _name
        surname = _surname
        second_name = _second
        age = _age
        currentSpeed = _speed
    }

    open fun getFullName(): String {
        return "$surname $name $second_name"
    }

    open fun move() {
        val angle = Random.nextDouble(0.0, 2 * PI)
        val distance = Random.nextInt(0, currentSpeed + 1)

        x += (distance * cos(angle)).toInt()
        y += (distance * sin(angle)).toInt()
        println("${name} переместился в (${x}, ${y})")
    }
}

class Driver : Human {
    constructor(_name: String, _surname: String, _second: String, _age: Int, _speed: Int)
            : super(_name, _surname, _second, _age, _speed)

    override fun move() {
        x += currentSpeed
        println("Водитель $name едет прямо: (${x}, ${y})")
    }
}

fun main() {
    val people = arrayOf(
        Human("Петя", "Иванов", "Петрович", 20, 5),
        Human("Анна", "Петрова", "Игоревна", 22, 4),
        Human("Виктор", "Сидоров", "Алексеевич", 21, 6),
        Human("Ольга", "Васильева", "Сергеевна", 19, 3)
    )
    val driver = Driver("Егор", "Григорьев", "Васильевич", 35, 8)
    val simulationTime = 5
    val threads = mutableListOf<Thread>()
    for (person in people) {
        val thread = thread {
            repeat(simulationTime) {
                person.move()
                Thread.sleep(300)
            }
        }
        threads.add(thread)
    }

    val driverThread = thread {
        repeat(simulationTime) {
            driver.move()
            Thread.sleep(300)
        }
    }
    threads.add(driverThread)
    threads.forEach { it.join() }
    println("\nФинальные позиции:")
    for (person in people) {
        println("${person.getFullName()}: (${person.x}, ${person.y})")
    }
    println("${driver.getFullName()}: (${driver.x}, ${driver.y})")
}